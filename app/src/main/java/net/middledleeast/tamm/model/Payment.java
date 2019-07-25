package net.middledleeast.tamm.model;

public class Payment {
    private String mPaymentLabel;
    private int mPaymentMethodImage;

    public Payment(String paymentLabel, int paymentMethodImage) {
        mPaymentLabel = paymentLabel;
        mPaymentMethodImage = paymentMethodImage;
    }

    public String getPaymentLabel() {
        return mPaymentLabel;
    }

    public void setPaymentLabel(String paymentModel) {
        mPaymentLabel = paymentModel;
    }

    public int getPaymentMethodImage() {
        return mPaymentMethodImage;
    }

    public void setPaymentMethodImage(int paymentMethodImage) {
        mPaymentMethodImage = paymentMethodImage;
    }
}
