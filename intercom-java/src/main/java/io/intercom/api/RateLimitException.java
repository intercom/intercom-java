package io.intercom.api;

public class RateLimitException extends IntercomException {

    private static final long serialVersionUID = -6100754169056165622L;

    private int rateLimit;

    private int remainingRequests;

    private long resetTime;

    public RateLimitException(String message) {
        super(message);
    }

    public RateLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateLimitException(ErrorCollection errorCollection) {
        super(errorCollection);
    }

    public RateLimitException(ErrorCollection errorCollection, int rateLimit,
            int remainingRequests, long resetTime) {
        super(errorCollection);
        this.rateLimit = rateLimit;
        this.remainingRequests = remainingRequests;
        this.resetTime = resetTime;
    }

    public RateLimitException(ErrorCollection errorCollection, Throwable cause) {
        super(errorCollection, cause);
    }

    public int getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(int rateLimit) {
        this.rateLimit = rateLimit;
    }

    public int getRemainingRequests() {
        return remainingRequests;
    }

    public void setRemainingRequests(int remainingRequests) {
        this.remainingRequests = remainingRequests;
    }

    public long getResetTime() {
        return resetTime;
    }

    public void setResetTime(long resetTime) {
        this.resetTime = resetTime;
    }
}
