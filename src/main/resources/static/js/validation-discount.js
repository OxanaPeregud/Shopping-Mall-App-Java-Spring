function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function validateForm() {
    var discount = document.discountForm.discount.value;
    var discountStartDate = document.discountForm.discountStartDate.value;
    var discountEndDate = document.discountForm.discountEndDate.value;
    var shopId = document.discountForm.shopId.value;

    var discountErr = true;

    if (discount === "") {
        printError("discountErr", "Please enter discount");
    } else {
        var regex1 = /^[0-9]+$/;
        if (regex1.test(discount) === false) {
            printError("discountErr", "Please enter a valid discount (only numeric characters allowed)");
        } else {
            printError("discountErr", "");
            discountErr = false;
        }
    }

    if (discountErr === true) {
        return false;
    } else {
        var dataPreview = "You've entered the following details: \n" +
            "Discount: " + discount + "\n" +
            "Discount Start Date: " + discountStartDate + "\n" +
            "Discount End Date: " + discountEndDate + "\n" +
            "Shop ID: " + shopId;
        alert(dataPreview);
    }
}
