package com.example.backendtrial.catfact;

public class CatFactDTO {
    private String catFact;

    public CatFactDTO(String catFact) {
        this.catFact = catFact;
    }

    public String getCatFact() {
        return this.catFact;
    }

    public void setCatFact(String catFact) {
        this.catFact = catFact;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CatFactDTO)) return false;
        final CatFactDTO other = (CatFactDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$catFact = this.getCatFact();
        final Object other$catFact = other.getCatFact();
        if (this$catFact == null ? other$catFact != null : !this$catFact.equals(other$catFact)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CatFactDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $catFact = this.getCatFact();
        result = result * PRIME + ($catFact == null ? 43 : $catFact.hashCode());
        return result;
    }

    public String toString() {
        return "CatFactDTO(catFact=" + this.getCatFact() + ")";
    }
}
