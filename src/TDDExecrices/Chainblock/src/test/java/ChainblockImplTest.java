/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ChainblockImplTest {
    private static final Transaction TRANSACTION1 = Mockito.mock(Transaction.class);
    private static final Transaction TRANSACTION2 = Mockito.mock(Transaction.class);
    private static final Transaction TRANSACTION3 = Mockito.mock(Transaction.class);

    private Chainblock chainblock;

    @BeforeEach
    public void setUp() {
        chainblock = new ChainblockImpl();

        Mockito.when(TRANSACTION1.getId()).thenReturn(1);
        Mockito.when(TRANSACTION2.getId()).thenReturn(2);
        Mockito.when(TRANSACTION3.getId()).thenReturn(3);
    }

    @Test
    public void whenUseContainsAndChainblockIsEmptyOrTransactionDoesNotExist_thenReturnFalse() {
        assertFalse(chainblock.contains(TRANSACTION1));
    }

    @Test
    public void whenAddTransactionWithUniqueId_thenChainblockAddTransactionToTheEndOfTheList() {
        chainblock.add(TRANSACTION1);

        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void whenAddTransactionWithIdThatExist_thenChainblockDoNotAddTransaction() {
        chainblock.add(TRANSACTION1);
        chainblock.add(TRANSACTION1);

        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void whenUseContainsAndSuchTransactionExists_thenReturnTrue() {
        chainblock.add(TRANSACTION1);

        assertTrue(chainblock.contains(TRANSACTION1));
    }

    @Test
    public void whenUseContainsWithIdParameterAndSuchTransactionExists_thenReturnTrue() {
        chainblock.add(TRANSACTION1);

        assertTrue(chainblock.contains(1));
    }

    @Test
    public void whenUseContainsWithIdParameterAndChainblockIsEmptyOrTransactionDoesNotExist_thenReturnFalse() {
        assertFalse(chainblock.contains(1));
    }

    @Test
    public void whenCallGetByIdAndIdIsValid_thenReturnTransactionWithThatId() {
        chainblock.add(TRANSACTION1);

        Transaction transaction = chainblock.getById(1);

        assertEquals(TRANSACTION1.getId(), transaction.getId());
    }

    @Test
    public void whenCallGetByIdAndIdIsNotValid_thenThrowException() {
        chainblock.add(TRANSACTION1);

        assertThrows(IllegalArgumentException.class, () -> {
            Transaction transaction = chainblock.getById(2);
        });

    }

    @Test
    public void testChangeTransactionStatusAndTransactionExist() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.FAILED, "BG", "GR", 100);
        chainblock.add(transaction);

        chainblock.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);

        assertEquals(TransactionStatus.SUCCESSFUL, transaction.getTransactionStatus());
    }

    @Test
    public void testRemoveByIdTransactionWhenTransactionWithSuchIdExists() {
        chainblock.add(TRANSACTION1);

        chainblock.removeTransactionById(1);

        assertEquals(0, chainblock.getCount());
    }

    @Test
    public void whenRemoveByIdTransactionAndTransactionWithSuchIdDoesNotExist_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            chainblock.removeTransactionById(1);
        });
    }

    @Test
    public void whenCallGetByTransactionStatusAndSuchTransactionsExist_thenReturnIterableWithTheseTransactionsInDescendingOrderByAmount() {
        Mockito.when(TRANSACTION1.getTransactionStatus()).thenReturn(TransactionStatus.SUCCESSFUL);
        Mockito.when(TRANSACTION2.getTransactionStatus()).thenReturn(TransactionStatus.SUCCESSFUL);
        Mockito.when(TRANSACTION3.getTransactionStatus()).thenReturn(TransactionStatus.FAILED);

        Mockito.when(TRANSACTION1.getAmount()).thenReturn(100.0);
        Mockito.when(TRANSACTION2.getAmount()).thenReturn(200.0);
        Mockito.when(TRANSACTION3.getAmount()).thenReturn(300.0);

        chainblock.add(TRANSACTION1);
        chainblock.add(TRANSACTION2);
        chainblock.add(TRANSACTION3);

        Iterator<Transaction> successfulTransactions = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();

        StringBuilder str = new StringBuilder();
        while (successfulTransactions.hasNext()) {
            str.append(successfulTransactions.next().getAmount()).append(" ");
        }

        assertEquals("200.0 100.0 ", str.toString());
    }

    @Test
    public void whenCallGetByTransactionStatusAndSuchTransactionsDoNotExist_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Iterator<Transaction> successfulTransactions = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();
        });
    }

    @Test
    public void whenGetAllSendersWithTransactionStatusAndSuchSendersExist_thenReturnIterableOfTheseSenders() {
        Person sender1 = new Sender("Sam");
        Person sender2 = new Sender("Peter");
        Mockito.when(TRANSACTION1.getTransactionStatus()).thenReturn(TransactionStatus.SUCCESSFUL);
        Mockito.when(TRANSACTION2.getTransactionStatus()).thenReturn(TransactionStatus.SUCCESSFUL);
        Mockito.when(TRANSACTION3.getTransactionStatus()).thenReturn(TransactionStatus.ABORTED);

        Mockito.when(TRANSACTION1.getAmount()).thenReturn(5.0);
        Mockito.when(TRANSACTION2.getAmount()).thenReturn(6.0);
        Mockito.when(TRANSACTION3.getAmount()).thenReturn(2.0);

        sender1.getTransactions().add(TRANSACTION1);
        sender1.getTransactions().add(TRANSACTION2);
        sender1.getTransactions().add(TRANSACTION3);

        Transaction transaction = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "BG", "NE", 2);
        sender2.getTransactions().add(transaction);
        chainblock.getSenders().add(sender1);
        chainblock.getSenders().add(sender2);

        Iterator<String> successfulSenders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();

        StringBuilder str = new StringBuilder();
        while (successfulSenders.hasNext()) {
            str.append(successfulSenders.next()).append(" ");
        }

        assertEquals("Sam Sam Peter ", str.toString());
    }

    @Test
    public void whenGetAllSendersWithTransactionStatusAndSuchSendersDoesNotExist_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Iterator<String> successfulSenders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();
        });
    }

    @Test
    public void whenGetAllReceiversWithTransactionStatusAndSuchReceiverExist_thenReturnIterableOfTheseReceivers() {
        Person receiver1 = new Receiver("Sam");
        Person receiver2 = new Receiver("Peter");
        Mockito.when(TRANSACTION1.getTransactionStatus()).thenReturn(TransactionStatus.SUCCESSFUL);
        Mockito.when(TRANSACTION2.getTransactionStatus()).thenReturn(TransactionStatus.SUCCESSFUL);
        Mockito.when(TRANSACTION3.getTransactionStatus()).thenReturn(TransactionStatus.ABORTED);

        Mockito.when(TRANSACTION1.getAmount()).thenReturn(5.0);
        Mockito.when(TRANSACTION2.getAmount()).thenReturn(6.0);
        Mockito.when(TRANSACTION3.getAmount()).thenReturn(2.0);

        receiver1.getTransactions().add(TRANSACTION1);
        receiver1.getTransactions().add(TRANSACTION2);
        receiver1.getTransactions().add(TRANSACTION3);

        Transaction transaction = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "BG", "NE", 2);
        receiver2.getTransactions().add(transaction);
        chainblock.getReceivers().add(receiver1);
        chainblock.getReceivers().add(receiver2);

        Iterator<String> successfulReceivers = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();

        StringBuilder str = new StringBuilder();
        while (successfulReceivers.hasNext()) {
            str.append(successfulReceivers.next()).append(" ");
        }

        assertEquals("Sam Sam Peter ", str.toString());
    }

    @Test
    public void whenGetAllReceiversWithTransactionStatusAndSuchReceiverDoesNotExist_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Iterator<String> successfulReceivers = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();
        });
    }

    @Test
    public void testIteratorMethod() {
        chainblock.add(TRANSACTION1);

        assertTrue(chainblock.iterator().hasNext());
    }
}

*/
