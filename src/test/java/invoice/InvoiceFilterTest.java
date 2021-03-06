package invoice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class InvoiceFilterTest {

    @Test
    public void filterReturnsEmptyListWhenDatabaseHasNoItemsWithValueLessThan100() {
        //Arrange
        InvoiceFilter invoiceFilter = new InvoiceFilter(new InvoicesDaoStub());
        //Act
        var result = invoiceFilter.filter();
        //Assert
        assertEquals(0, result.size());
    }

    @Test
    public void testFilterUsingMockito() {
        var invoicesDaoMock = Mockito.mock(InvoicesDao.class);
        InvoiceFilter invoiceFilter = new InvoiceFilter(invoicesDaoMock);
        invoiceFilter.filter();
        Mockito.verify(invoicesDaoMock).all();
    }

    @Test
    public void testFilterUsingMockedStubOfAll() {
        var invoicesDaoMock = Mockito.mock(InvoicesDao.class);
        var list = new ArrayList<Invoice>();
        list.add(new Invoice("Test", 99.0));
        Mockito.when(invoicesDaoMock.all()).thenReturn(list);

        InvoiceFilter invoiceFilter = new InvoiceFilter(invoicesDaoMock);
        var result = invoiceFilter.filter();
        assertEquals(list, result);
    }
}