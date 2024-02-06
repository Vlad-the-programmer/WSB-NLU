
package store;

interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod{
    private String cardNumber;
    private String cardHolderName;
    
    // Constructors
    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" + "cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + '}';
    }

    // Getters Setters
    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}


class DebitCardPayment implements PaymentMethod{
    private String cardNumber;
    private String cardHolderName;
    
    // Constructors
    public DebitCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of $" + amount);
    }

    @Override
    public String toString() {
        return "DebitCardPayment{" + "cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + '}';
    }
    
    // Getters Setters
    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}


class BankTransferPayment implements PaymentMethod{
    private String bankName;
    private String accountNumber;
    
    // Constructors
    public BankTransferPayment(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of $" + amount);
    }

    @Override
    public String toString() {
        return "BankTransferPayment{" + "bankName=" + bankName + ", accountNumber=" + accountNumber + '}';
    }
    
    // Getters Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

public class Payment {
    private int paymentId;
    private String paymentMethod;
    private String cardNumber;
    private String cardHolderName;
    private String bankName;
    private String accountNumber;
    private double amount;
    private PAYMENT_STATUS paymentStatus;
    private static int idCounter;
    
    
    // Constructors
    public Payment(String paymentMethod, String cardNumber, 
            String cardHolderName, double amount, PAYMENT_STATUS paymentStatus) {
        this.paymentId = idCounter++;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
    
    public Payment(String paymentMethod, double amount, String bankName, 
            String accountNumber, PAYMENT_STATUS paymentStatus) {
        this.paymentId = idCounter++;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.paymentStatus = paymentStatus;
    }
    
    public void makePayment() {
        // Process payment by one of the Payment methods and set the Payment status to PAID
        
        if (paymentMethod.toLowerCase().equals("Credit Card".toLowerCase())) {
            CreditCardPayment payment = new CreditCardPayment(
                                                    cardNumber, cardHolderName);
            payment.processPayment(amount);
            this.paymentStatus = PAYMENT_STATUS.PAID;
        } 
        else if (paymentMethod.toLowerCase().equals("Debit Card".toLowerCase())) {
            DebitCardPayment payment = new DebitCardPayment(
                                                    cardNumber, cardHolderName);
            payment.processPayment(amount);
            this.paymentStatus = PAYMENT_STATUS.PAID;
        } 
        else if (paymentMethod.toLowerCase().equals("Bank Transfer".toLowerCase())) {
            BankTransferPayment payment = new BankTransferPayment(
                                                       accountNumber, bankName);
            payment.processPayment(amount);
            this.paymentStatus = PAYMENT_STATUS.PAID;
        } 
        else {
            System.out.println("The payment method provided is not valid...");
        }
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", paymentMethod=" + paymentMethod + ", cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", bankName=" + bankName + ", accountNumber=" + accountNumber + ", amount=" + amount + ", paymentStatus=" + paymentStatus + '}';
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public PAYMENT_STATUS getPaymentStatus() {
        return paymentStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setters
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPaymentStatus(PAYMENT_STATUS paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
