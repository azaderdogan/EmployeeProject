package Person;

public class Employees {
    private int id;
    private String fname;
    private String lname;
    private float salary;
    private int age;
    private String department;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String education;
    private String experience;
    private String contractStart;
    private String contractEnd;
    private String nationaly;
    private String motherLanguage;
    private String otherLanguage;
    public Employees(){}

    public Employees(int id, String fname, String lname, float salary, int age, String department, String address, String dateOfBirth) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.age = age;
        this.department = department;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public Employees( String fname, String lname, float salary, int age, String department, String address,
                     String dateOfBirth, String gender, String education, String experience, String contractStart,
                     String contractEnd, String nationaly, String motherLanguage, String otherLanguage) {

        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.age = age;
        this.department = department;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.education = education;
        this.experience = experience;
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
        this.nationaly = nationaly;
        this.motherLanguage = motherLanguage;
        this.otherLanguage = otherLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getContractStart() {
        return contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public String getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }

    public String getNationaly() {
        return nationaly;
    }

    public void setNationaly(String nationaly) {
        this.nationaly = nationaly;
    }

    public String getMotherLanguage() {
        return motherLanguage;
    }

    public void setMotherLanguage(String motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    public String getOtherLanguage() {
        return otherLanguage;
    }

    public void setOtherLanguage(String otherLanguage) {
        this.otherLanguage = otherLanguage;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", education='" + education + '\'' +
                ", experience='" + experience + '\'' +
                ", contractStart='" + contractStart + '\'' +
                ", contractEnd='" + contractEnd + '\'' +
                ", nationaly='" + nationaly + '\'' +
                ", motherLanguage='" + motherLanguage + '\'' +
                ", otherLanguage='" + otherLanguage + '\'' +
                '}';
    }
}
