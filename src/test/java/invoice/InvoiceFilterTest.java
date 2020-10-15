package invoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceFilterTest {

    @Test
    public void filterReturnsEmptyListWhenDatabaseHasNoItemsWithValueLessThan100() {
        //Arrange
        InvoiceFilter invoiceFilter = new InvoiceFilter( new InvoicesDaoStub() );
        //Act
        var result = invoiceFilter.filter();
        //Assert
        assertEquals(0, result.size());
    }
}