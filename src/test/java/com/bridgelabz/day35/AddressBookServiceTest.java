package com.bridgelabz.day35;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.bridgelabz.day35.AddressBookService.IOService.DB_IO;
import static org.junit.jupiter.api.Assertions.*;

class AddressBookServiceTest
{
    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchThePeopleCount() {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookDataList = addressBookService.readAddressBookData(DB_IO);
        assertEquals(5,addressBookDataList.size());
    }
    @Test
    public void givenNewPhoneNumber_ShouldUpdateTheRecordAndSyncWithDataBase() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(DB_IO);
        addressBookService.updateRecord("Piyush", "9910936991");
        boolean result = addressBookService.checkRecordSyncWithDB("Piyush");
        assertTrue(result);
    }
}
