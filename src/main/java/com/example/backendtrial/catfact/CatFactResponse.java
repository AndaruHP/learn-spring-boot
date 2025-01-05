package com.example.backendtrial.catfact;

public class CatFactResponse {
    private String fact;
    private int length;

    public CatFactResponse() {
    }

    public String getFact() {
        return this.fact;
    }

    public int getLength() {
        return this.length;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CatFactResponse)) return false;
        final CatFactResponse other = (CatFactResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$fact = this.getFact();
        final Object other$fact = other.getFact();
        if (this$fact == null ? other$fact != null : !this$fact.equals(other$fact)) return false;
        if (this.getLength() != other.getLength()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CatFactResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $fact = this.getFact();
        result = result * PRIME + ($fact == null ? 43 : $fact.hashCode());
        result = result * PRIME + this.getLength();
        return result;
    }

    public String toString() {
        return "CatFactResponse(fact=" + this.getFact() + ", length=" + this.getLength() + ")";
    }
}
