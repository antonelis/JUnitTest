package invoice;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceFilter {

    private final InvoicesDao invoicesDao;

    public InvoiceFilter(InvoicesDao invoicesDao) {
        this.invoicesDao = invoicesDao;
    }


    public List<Invoice> filter() {
        //Must be modified to use dependency inversion
        H2MemInvoicesDao h2MemInvoicesDao = new H2MemInvoicesDao();
        List<Invoice> allInvoices = h2MemInvoicesDao.all();

        return allInvoices.stream()
                .filter(invoice -> invoice.getValue() < 100.0)
                .collect(Collectors.toList());
    }
}