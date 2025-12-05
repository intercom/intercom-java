package com.intercom.api.integration;

import com.intercom.api.Intercom;
import com.intercom.api.core.pagination.SyncPage;
import com.intercom.api.core.pagination.SyncPagingIterable;
import com.intercom.api.resources.contacts.requests.DeleteContactRequest;
import com.intercom.api.resources.contacts.types.ContactsCreateResponse;
import com.intercom.api.resources.notes.requests.CreateContactNoteRequest;
import com.intercom.api.resources.notes.requests.FindNoteRequest;
import com.intercom.api.resources.notes.requests.ListContactNotesRequest;
import com.intercom.api.resources.notes.types.Note;
import com.intercom.api.types.CreateContactRequest;
import com.intercom.api.utils.TestClientFactory;
import com.intercom.api.utils.Utils;
import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotesTest {

    private Intercom client;
    private String adminId;
    private ContactsCreateResponse contact;
    private String contactId;
    private Note note;
    private int noteId;

    @BeforeEach
    public void before() {
        // arrange
        client = TestClientFactory.create();
        adminId = client.admins().list().getAdmins()
                .orElseThrow(() -> new RuntimeException("Admins list is required"))
                .get(0)
                .orElseThrow(() -> new RuntimeException("Admin is required"))
                .getId();

        contact = client.contacts()
                .create(CreateContactRequest.of(CreateContactRequest.WithExternalId.builder()
                        .externalId(Utils.randomString())
                        .build()));
        contactId = contact.getId()
                .orElseThrow(() -> new RuntimeException("Contact ID is required"));

        note = client.notes()
                .create(CreateContactNoteRequest.builder()
                        .contactId(contactId)
                        .body(Utils.randomString())
                        .adminId(adminId)
                        .build());
        noteId = Integer.parseInt(note.getId()
                .orElseThrow(() -> new RuntimeException("Note ID is required")));
    }

    @AfterEach
    public void after() {
        // cleanup
        tryDeleteContact();
    }

    @Test
    public void testCreate() {
        // assert
        Assertions.assertNotNull(note);
    }

    @Test
    public void testFind() {
        // act
        Note response = client.notes()
                .find(FindNoteRequest.builder().noteId(noteId).build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testList() {
        // act
        SyncPagingIterable<Note> response = client.notes()
                .list(ListContactNotesRequest.builder()
                        .contactId(contactId)
                        .perPage(25)
                        .page(1)
                        .build());

        // assert
        Assertions.assertNotNull(response);
    }

    @Test
    public void testPaginationIterator() {
        // arrange
        int limit = 2;
        client.notes()
                .create(CreateContactNoteRequest.builder()
                        .contactId(contactId)
                        .body("one")
                        .build());
        client.notes()
                .create(CreateContactNoteRequest.builder()
                        .contactId(contactId)
                        .body("two")
                        .build());

        // act
        Iterator<Note> iterator = client.notes()
                .list(ListContactNotesRequest.builder()
                        .contactId(contactId)
                        .perPage(1)
                        .build())
                .iterator();

        // assert
        Assertions.assertNotNull(iterator);

        int count = 0;
        while (iterator.hasNext()) {
            Note item = iterator.next();

            Assertions.assertNotNull(item);
            Assertions.assertNotNull(item.getId());

            count++;

            if (count >= limit) {
                break;
            }
        }

        Assertions.assertTrue(count >= 2);
    }

    @Test
    public void testPaginationPager() {
        // arrange
        int limit = 2;
        client.notes()
                .create(CreateContactNoteRequest.builder()
                        .contactId(contactId)
                        .body("one")
                        .build());
        client.notes()
                .create(CreateContactNoteRequest.builder()
                        .contactId(contactId)
                        .body("two")
                        .build());

        // act
        SyncPagingIterable<Note> pager = client.notes()
                .list(ListContactNotesRequest.builder()
                        .contactId(contactId)
                        .perPage(1)
                        .build());

        // assert
        Assertions.assertNotNull(pager);

        int count = 0;
        while (pager.hasNext()) {
            SyncPage<Note> page = pager.nextPage();
            count += page.getItems().size();

            if (count >= limit) {
                break;
            }
        }

        Assertions.assertTrue(count >= 2);
    }

    private void tryDeleteContact() {
        try {
            client.contacts()
                    .delete(DeleteContactRequest.builder()
                            .contactId(contactId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete contact.", e);
        }
    }
}
