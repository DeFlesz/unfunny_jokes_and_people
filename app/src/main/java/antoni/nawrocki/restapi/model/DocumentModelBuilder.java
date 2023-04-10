package antoni.nawrocki.restapi.model;

import android.util.Log;

public class DocumentModelBuilder {
    private String title;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String pictureURL;
    private String bigPictureURL;
    private String phoneNumber;
    private String email;
    private String adress;
    private String nationality;

    public DocumentModelBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public DocumentModelBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public DocumentModelBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public DocumentModelBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public DocumentModelBuilder setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
        return this;
    }

    public DocumentModelBuilder setBigPictureURL(String bigPictureURL) {
        this.bigPictureURL = bigPictureURL;
        return this;
    }

    public DocumentModelBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public DocumentModelBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public DocumentModelBuilder setAddress(String address) {
        this.adress = address;
        return this;
    }

    public DocumentModelBuilder setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public DocumentModel build() {
        return new DocumentModel(title, firstName, lastName, birthDate, pictureURL, bigPictureURL, phoneNumber, email, adress, nationality);
    }
}