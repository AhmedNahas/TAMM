package payments;


import com.wirecard.ecom.card.model.CardPayment;
import com.wirecard.ecom.model.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentObjectProvider {


    public CardPayment getCardPayment(boolean isAnimated) {
        String timestamp = SignatureHelper.generateTimestamp();
        String merchantID = "33f6d473-3036-4ca5-acb5-8c64dac862d1";
        String secretKey = "9e0130f6-2e1e-4185-b0d5-dc69079c75cc";
        String requestID = UUID.randomUUID().toString();
        TransactionType transactionType = TransactionType.PURCHASE;
        BigDecimal amount = new BigDecimal(1);
        String currency = "USD";
        String signature = SignatureHelper.generateSignature(timestamp, merchantID, requestID, transactionType.getValue(), amount, currency, secretKey);

        CardPayment cardPayment = new CardPayment.Builder()
                .setSignature(signature)
                .setMerchantAccountId(merchantID)
                .setRequestId(requestID)
                .setAmount(amount)
                .setTransactionType(transactionType)
                .setCurrency(currency)
                .build();
        cardPayment.setRequireManualCardBrandSelection(false);
        cardPayment.setAnimatedCardPayment(isAnimated);
        return cardPayment;
    }


}
