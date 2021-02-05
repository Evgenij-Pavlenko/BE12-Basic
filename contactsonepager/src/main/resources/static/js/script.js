document.addEventListener("DOMContentLoaded", function main() {
    const formDom = document.querySelector("#contact-form");
    const contactTemplateDom = document.querySelector("#contact-template");
    const contactWrapperDom = document.querySelector("#contact-wrapper");

    const contactClient = new ContactClient();
    const htmlRenderer = new HtmlRenderer(contactTemplateDom, contactWrapperDom, formDom);

    const formController = new FormController(contactClient, htmlRenderer);
    const contactController = new ContactController(htmlRenderer);


    formDom.addEventListener("click", formController);
    contactWrapperDom.addEventListener("click", contactController);
});

const REAL_CONTACT_CLASS = "real-contact";

class ContactController {
    constructor(htmlRenderer, contactClient) {
        this.htmlRenderer = htmlRenderer;
        this.contactClient = contactClient;
    }

    handleEvent(event) {
        const action = event.target.dataset.action
        if (action !== undefined)
            this[action](event);
    }

    toggleDetails(event) {
        this.htmlRenderer.toggleContactDetails(event);
    }

    edit(event) {
        this.htmlRenderer.toEditForm(event);
    }
 // undefended
     delete(event) {
        const contactId = event.target.closest(`.${REAL_CONTACT_CLASS}`).contact.id;
        console.log('ID: ', contactId);

        // ERROR: Uncaught TypeError: Cannot read property 'delete' of undefined
      this.contactClient.delete(contactId);
    }
}

class FormController {

    constructor(contactClient, htmlRenderer) {
        this.contactClient = contactClient;
        this.htmlRenderer = htmlRenderer;
        this._init();
    }

    async _init() {
        const response = await this.contactClient.getAll();
        if (response.ok) {
            const contacts = await response.json();
            this.htmlRenderer.renderContacts(contacts);
        }
    }

    handleEvent(event) {
        event.stopPropagation();
        const action = event.target.dataset.action
        if (action !== undefined)
            this[action](event);
    }

    async add(event) {
        const formDom = event.currentTarget;

        const contact = {
            name: formDom.elements.name.value,
            lastName: formDom.elements.lastName.value,
            age: formDom.elements.age.value,
        };

        const response = await this.contactClient.add(contact);
        if (response.ok) {
            this._init();
            this.htmlRenderer.clearForm();
        }

    }

    async edit(event) {
        ////TODO complete. See method 'add'
        const formDom = event.currentTarget;

        const contact = {
            id: formDom.elements.id.value,
            name: formDom.elements.name.value,
            lastName: formDom.elements.lastName.value,
            age: formDom.elements.age.value,
        };

        const response = await this.contactClient.edit(contact);
        if (response.ok) {
            this._init();
            this.htmlRenderer.clearForm();
        }
    }

    cancel(event) {
        this.htmlRenderer.toAddForm();
    }

    async delete(event) {
        const id = this.htmlRenderer.formDom.currentTarget.elements.id.value;
        console.log('FormDom: ', formDom);
        // const id = event.currentTarget.elements.id.value;

        const response = await this.contactClient.delete(id);
        if (response.ok) {
            this._init();
        }
    }



}

/**
 * The responsibility of the class is render data and change HTML.
 */
class HtmlRenderer {

    constructor(contactTemplateDom, contactWrapperDom, formDom) {
        this.contactTemplateDom = contactTemplateDom;
        this.contactWrapperDom = contactWrapperDom;
        this.formDom = formDom;

        this.addButtonDom = formDom.querySelector("#add-button");
        this.editButtonDom = formDom.querySelector("#edit-button");
        this.cancelButtonDom = formDom.querySelector("#cancel-button");
    }

    renderContacts(contacts) {
        this.removeAll();
        for (let contact of contacts) {
            let contactDom = this.renderContact(contact);
            this.contactWrapperDom.append(contactDom);
        }
    }

    removeAll() {
        let contactsDom = this.contactWrapperDom.querySelectorAll(`.${REAL_CONTACT_CLASS}`);
        for (let contactDom of contactsDom) {
            contactDom.remove();
        }
    }

    renderContact(contact) {
        const res = this.contactTemplateDom.cloneNode(true);
        res.contact = contact;
        res.classList.remove("hide");
        res.classList.add(REAL_CONTACT_CLASS);
        const contactDetailsLink = res.querySelector(".contact-details-link");
        contactDetailsLink.innerHTML = `${contact.name} ${contact.lastName}`;

        res.querySelector(".name-value").innerHTML = contact.name;
        res.querySelector(".second-name-value").innerHTML = contact.lastName;
        res.querySelector(".age-value").innerHTML = contact.age;

        return res;
    }

    clearForm() {
        this.formDom.elements.name.value = null;
        this.formDom.elements.lastName.value = null;
        this.formDom.elements.age.value = null;
    }

    toggleContactDetails(event) {
        const contactDetailsDom = event.target.closest(".real-contact").querySelector(".contact-details");
        contactDetailsDom.classList.toggle("hide");
    }

    toEditForm(event) {
        const contactDom = event.target.closest(`.${REAL_CONTACT_CLASS}`);
        const contact = contactDom.contact;

        this.formDom.elements.name.value = contact.name;
        this.formDom.elements.lastName.value = contact.lastName;
        this.formDom.elements.age.value = contact.age;
        this.formDom.elements.id.value = contact.id;

        this.addButtonDom.classList.add("hide");
        this.editButtonDom.classList.remove("hide");
        this.cancelButtonDom.classList.remove("hide");
    }

    toAddForm() {
        this.clearForm()

        this.editButtonDom.classList.add("hide");
        this.cancelButtonDom.classList.add("hide");
        this.addButtonDom.classList.remove("hide");
    }

}

class ContactClient {
    static CONTACTS_PATH = "/api/contacts";

    add(contact) {
        return fetch(ContactClient.CONTACTS_PATH, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    }

    getAll() {
        return fetch(ContactClient.CONTACTS_PATH, {
            method: 'GET',
        });
    }

    ////TODO add methods edit(contact) and remove(contact)

    edit(contact) {

        return fetch(ContactClient.CONTACTS_PATH, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    }

    delete(id) {
        console.log('Delete ', id);
        console.log(ContactClient.CONTACTS_PATH + `/${id}`);
        return fetch(ContactClient.CONTACTS_PATH + `/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    }

}
