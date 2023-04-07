package payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    //Campos de clase:
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;


    //Método común normalmente llamado setup:
    @BeforeEach   //se ejecuta cada vez antes de cada método:
    public void setup() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {
        //Preparación objetos:
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        //Ejecución método:
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        //Comprobación:
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_incorrect() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000)); //como el gateway ha ido bien, el paso se hace
    }
}