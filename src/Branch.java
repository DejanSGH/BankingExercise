import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double transactions){
        if(findCustomer(customerName) != null){
            //System.out.println("Customer with name " + customerName + " already exist");
            return false;
        }
        //System.out.println("Customer with name " + customerName + " was added");
        return customers.add(new Customer(customerName, transactions));
    }

    public boolean addCustomerTransaction(String customerName, double transaction){
        Customer customer = findCustomer(customerName);
        return customer.getTransactions().add(transaction);
    }

    private Customer findCustomer(String customerName){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customerName)){
                return customers.get(i);
            }
        }
        return null;
    }

}
