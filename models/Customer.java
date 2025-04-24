package models;

public class Customer extends User {
    private String membershipType;

    public Customer() 
    {
        super();
    }

    public Customer(String userId, String name, String gender, int age, String email, String phoneNo, String address, int role, String securityAns, String password, String membershipType) 
    {
        super(userId, role, securityAns, password);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.membershipType = membershipType;
    }

    public void setMembershipType(String membershipType) 
    {
        this.membershipType = membershipType;
    }

    public String getMembershipType() 
    {
        return this.membershipType;
    }

    public String toStringCustomer() 
    {
        String str = this.userId + "," + this.name + "," + this.gender + "," + this.age + "," + this.email + "," + this.phoneNo + "," + this.address + "," + this.role + "," + this.securityAns + "," + this.password + "," + this.membershipType + "\n";
        return str;
    }

    public Customer formCustomer(String str) 
    {
        String[] data = str.split(",");

        Customer c = new Customer();
        c.setUserId(data[0]);
        c.setName(data[1]);
        c.setGender(data[2]);
        c.setAge(Integer.parseInt(data[3]));
        c.setEmail(data[4]);
        c.setPhoneNo(data[5]);
        c.setAddress(data[6]);
        c.setRole(Integer.parseInt(data[7]));
        c.setSecurityAns(data[8]);
        c.setPassword(data[9]);
        c.setMembershipType(data[10]);

        return c;
    }
}
