package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.types.CreateArticleRequest;
import com.intercom.api.resources.articles.requests.DeleteArticleRequest;
import com.intercom.api.resources.articles.requests.FindArticleRequest;
import com.intercom.api.resources.articles.requests.ListArticlesRequest;
import com.intercom.api.resources.articles.requests.UpdateArticleRequest;
import com.intercom.api.resources.articles.types.Article;
import com.intercom.api.resources.articles.types.ArticleListItem;
import com.intercom.api.resources.helpcenter.types.Collection;
import com.intercom.api.resources.helpcenters.collections.requests.ListCollectionsRequest;
import com.intercom.api.types.AdminList;
import com.intercom.api.types.ArticleContent;
import com.intercom.api.types.ArticleTranslatedContent;
import com.intercom.api.types.DeletedArticleObject;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArticlesTest {

    private Intercom client;
    private Article article;
    private int articleId;
    private boolean deleteAfter;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        SyncPagingIterable<Collection> randomCollections = client.helpCenters()
                .collections()
                .list(ListCollectionsRequest.builder().perPage(1).build());
        AdminList randomAdmins = client.admins().list();

        Integer parentId = Integer.parseInt(randomCollections.getItems().get(0).getId());
        int adminId = Integer.parseInt(randomAdmins.getAdmins()
                .orElseThrow(() -> new RuntimeException("Admins list is required"))
                .get(0)
                .orElseThrow(() -> new RuntimeException("Admin is required"))
                .getId());

        // act
        article = createArticle(parentId, adminId);
        articleId = Integer.parseInt(article.getId());

        deleteAfter = true;
    }

    @AfterEach
    public void after() {
        if (deleteAfter) {
            // cleanup
            tryDeleteArticle(articleId);
        }
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertNotNull(article);
    }

    @Test
    public void testFind() {
        // act
        Article response = client.articles()
                .find(FindArticleRequest.builder().articleId(articleId).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testUpdate() {
        // act
        Article response = client.articles()
                .update(UpdateArticleRequest.builder()
                        .articleId(articleId)
                        .title("Biba & Boba")
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testList() {
        // act
        SyncPagingIterable<ArticleListItem> response = client.articles()
                .list(ListArticlesRequest.builder().page(1).perPage(12).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDelete() {
        // act
        DeletedArticleObject response = client.articles()
                .delete(DeleteArticleRequest.builder().articleId(articleId).build());
        deleteAfter = false;

        // assert
        Assertions.assertNotNull(response);
    }

    private Article createArticle(Integer parentId, int adminId) {
        return client.articles()
                .create(java.util.Optional.of(CreateArticleRequest.builder()
                        .title(Utils.randomString())
                        .authorId(adminId)
                        .description(Utils.randomString())
                        .body("<b>Eins Zwei</b>")
                        .state(CreateArticleRequest.State.DRAFT)
                        .parentId(parentId)
                        .parentType(CreateArticleRequest.ParentType.COLLECTION)
                        .translatedContent(ArticleTranslatedContent.builder()
                                .fr(ArticleContent.builder()
                                        .title("Allez les verts")
                                        .description("French description")
                                        .body("<p>French body in html</p>")
                                        .authorId(adminId)
                                        .state(ArticleContent.State.DRAFT)
                                        .build())
                                .build())
                        .build()));
    }

    private void tryDeleteArticle(int articleId) {
        try {
            client.articles()
                    .delete(DeleteArticleRequest.builder().articleId(articleId).build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete article.", e);
        }
    }
}
