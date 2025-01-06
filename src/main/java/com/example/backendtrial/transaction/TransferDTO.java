package com.example.backendtrial.transaction;

public class TransferDTO {
    private String fromUser;
    private String toUser;
    private Double amount;

    public TransferDTO() {
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public String getToUser() {
        return this.toUser;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TransferDTO)) return false;
        final TransferDTO other = (TransferDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$fromUser = this.getFromUser();
        final Object other$fromUser = other.getFromUser();
        if (this$fromUser == null ? other$fromUser != null : !this$fromUser.equals(other$fromUser)) return false;
        final Object this$toUser = this.getToUser();
        final Object other$toUser = other.getToUser();
        if (this$toUser == null ? other$toUser != null : !this$toUser.equals(other$toUser)) return false;
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TransferDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $fromUser = this.getFromUser();
        result = result * PRIME + ($fromUser == null ? 43 : $fromUser.hashCode());
        final Object $toUser = this.getToUser();
        result = result * PRIME + ($toUser == null ? 43 : $toUser.hashCode());
        final Object $amount = this.getAmount();
        result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
        return result;
    }

    public String toString() {
        return "TransferDTO(fromUser=" + this.getFromUser() + ", toUser=" + this.getToUser() + ", amount=" + this.getAmount() + ")";
    }
}
