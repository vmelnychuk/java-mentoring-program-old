package io.neko.model;

public class SubscriberInfo {
    private final String name;
    private final String callbackUrl;

    public SubscriberInfo(String name, String callbackUrl) {
        this.name = name;
        this.callbackUrl = callbackUrl;
    }

    public String getName() {
        return name;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriberInfo that = (SubscriberInfo) o;

        if (!name.equals(that.name)) return false;
        return callbackUrl.equals(that.callbackUrl);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + callbackUrl.hashCode();
        return result;
    }
}
