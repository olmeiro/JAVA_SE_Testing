package payments;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    @Test
    public void payment_is_correct() {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        boolean result = paymentProcessor.makePayment(1000);
        assertTrue(paymentProcessor.makePayment(1000)); //como el gateway ha ido bien, el paso se hace
    }

    @Test
    public void payment_is_incorrect() {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        boolean result = paymentProcessor.makePayment(1000);
        assertFalse(paymentProcessor.makePayment(1000)); //como el gateway ha ido bien, el paso se hace
    }

}