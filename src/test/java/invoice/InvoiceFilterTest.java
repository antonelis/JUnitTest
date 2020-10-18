package invoice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
}