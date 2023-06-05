import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) {
            //System.out.println("Branch with name " + branchName + " already exist");
            return false;
        }
        //System.out.println("Branch with name " + branchName + " was added");
        return branches.add(new Branch(branchName));
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, transaction);
        }
        return false;
    }

//    public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double transaction) {
//        Branch foundBranch = findBranch(nameOfBranch);
//        if(foundBranch != null) {
//            return foundBranch.newCustomer(nameOfCustomer,transaction);
//        }
//        return false;
//    }
//
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        for (Customer c : branch.getCustomers()) {
            if (c.getName().equals(customerName)) {
                branch.addCustomerTransaction(customerName, transaction);
                return true;
            }
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {

        if (findBranch(branchName) != null) {
            Branch branch = findBranch(branchName);
            if (printTransactions) {
                System.out.println("Customer details for branch " + branchName);
                for (int i = 0; i < branch.getCustomers().size(); i++) {
                    int num = i + 1;
                    Customer customer = branch.getCustomers().get(i);
                    System.out.println("Customer: " + customer.getName() + "[" + num + "]");
                    System.out.println("Transactions");
                    for (int j = 1; j < customer.getTransactions().size()+1; j++) {
                        //int num2 += j;
                        System.out.println("[" + j + "]" + "  Amount " + customer.getTransactions().get(j-1));
                    }
                }
            }else{
                System.out.println("Customer details for branch " + branchName);
                for (int i = 1; i < branch.getCustomers().size()+1; i++) {
                    Customer customer = branch.getCustomers().get(i-1);
                    System.out.println("Customer: " + customer.getName() + "[" + i + "]");
                }
            }
            //return true;
        }
        return false;
    }

    private Branch findBranch(String branchName) { // name of the branch
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                return branches.get(i);
            }
        }
        return null;
    }


}
