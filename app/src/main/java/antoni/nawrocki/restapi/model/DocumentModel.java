package antoni.nawrocki.restapi.model;

public class DocumentModel {
//  name
    String title;
    String firstName;
    String lastName;

//  dob
    String birthDate;

    String pictureURL;
    String bigPictureURL;

    String phoneNumber;
    String email;
    String address;

    String nationality;



    public DocumentModel(String title, String firstName, String lastName, String birthDate, String pictureURL, String bigPictureURL, String phoneNumber, String email, String address, String nationality) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.pictureURL = pictureURL;
        this.bigPictureURL = bigPictureURL;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getBigPictureURL() {
        return bigPictureURL;
    }

    public void setBigPictureURL(String bigPictureURL) {
        this.bigPictureURL = bigPictureURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "DocumentModel{" +
                "title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
