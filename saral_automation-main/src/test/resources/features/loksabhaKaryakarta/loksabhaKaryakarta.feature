Feature: Testing data entry for loksabha level karyakarta
Background:
Given user logged in into the saral application
|Email   |state.adminup@gmail.com|
|Password|Abc@1234               |
|Otp     |010203                 |
Scenario: Testing loksabha karyakarta add data entry functionality
Then user click on sangathan data management card on dashboard
And user click on add entry button for loksabha karyakarta
And user select loksabha karyakarta data filter
|Input Fields           |Input Data       |
|Loksabha               |- Saharanpur     |
|Organisation Unit      |Core Sangathan   |
|Organisation Sub Unit  |Office Bearer    | 
And user click on search button and verify loksabha karyakarta filter text
And user clicks on enter more details
Then user input below details in data entry form with input fields validation
|Input Fields                   |Input Data                    |
|Name                           |loksabha Karyakarta Automation|
|Father Name                    |testautomation                |
|Designation                    |LSDesigDisplay                |
|Phone Number                   |8111112233                    |
|Has Smartphone                 |Yes                           |
|Primary Member ID              |1234567000                    |
|Age                            |45                            |
|Gender                         |Female                        |
|WhatsApp Number                |7687984587                    |
|STD Code                       |6756768                       |
|Landline Number                |7857787545767                 |
|Category                       |OBC                           |
|Caste                          |Das                           |
|Email                          |wardkarya@gamil.com           |
|Dob                            |02/Jan/1972                   |
|Full Address                   |Paschim Vihar New Delhi-110063|
|Village                        |Demo Village                  |
|Taluka                         |Demo Taluka                   |
|District                       |Agra                          |
|Pin Code                       |110067                        |
|Education                      |Post Graduate                 |
|Profession                     |Teacher                       |
|Bike                           |Yes                           |
|Car                            |Yes                           |
|Vidhan Sabha where he/she votes|1 - Behat                     |
|Booth where he/she votes       |1                             |
|Voter Id                       |63721638168                   |
|Aadhaar Number                 |732176387127                  |
|Panna Number                   |6                             |
|Ration Card Number             |6376876876                    |
|Facebook Profile               |abc@gmail.com                 |
|Twitter Profile                |xyz@gmail.com                 |
|Intagram Profile               |tyui@gmail.com                |
|Linkedin Profile               |sdghjhjh@gmail.com            |
|Image                          |abc                           |
|Salutation                     |Shri                          |
|Sub Caste                      |qwert123                      |
|Qualification                  |qwert123                      |
|Religion                       |Islam                         |
|Active Member Id               |647236816381768               |
|Party Zila                     |Aazamgarh                     |
|Party Mandal                   |Ajmatgarh                     |
|Blood Group                    |A+                            |
And user click on add button
And user click on edit button for recently added entry
And user verify all the added data
#When user enter data with duplicate phone which is already exist on given data level, unit, and subunit
Then user edit all the added data with new data
|Input Fields                   |Edit Input Data                    |
|Name                           |loksabha Karyakarta Automation Edit|
|Father Name                    |testautomationedit                 |
|Designation                    |LSDesigDisplay                     |
|Phone Number                   |8111112265                         |
|Has Smartphone                 |No                                 |
|Primary Member ID              |1234567877                         |
|Age                            |48                                 |
|Gender                         |Male                               |
|WhatsApp Number                |7687984586                         |
|STD Code                       |6756790                            |
|Landline Number                |7857787545769                      |
|Category                       |SC                                 |
|Caste                          |Pasi                               |
|Email                          |wardkaryaedit@gamil.com            |
|Dob                            |02/Jan/1973                        |
|Full Address                   |Paschim Vihar New Delhi-110065     |
|Village                        |Demo Village edit                  |
|Taluka                         |Demo Taluka edit                   |
|District                       |Aligarh                            |
|Pin Code                       |110068                             |
|Education                      |Doctorate                          |
|Profession                     |Advocate                           |
|Bike                           |No                                 |
|Car                            |No                                 |
|Vidhan Sabha where he/she votes|2 - Nakur                          |
|Booth where he/she votes       |1                                  |
|Voter Id                       |63721638190                        |
|Aadhaar Number                 |732176387190                       |
|Panna Number                   |9                                  |
|Ration Card Number             |6376876890                         |
|Facebook Profile               |abcedit@gmail.com                  |
|Twitter Profile                |xyzedit@gmail.com                  |
|Intagram Profile               |tyuiedit@gmail.com                 |
|Linkedin Profile               |sdghjhjhedit@gmail.com             |
|Image                          |xyz                                |
|Salutation                     |Smt                                |
|Sub Caste                      |qwertedit123                       |
|Qualification                  |qwertEdit123                       |
|Religion                       |Hinduism                           |
|Active Member Id               |647236816381790                    |
|Party Zila                     |Agra Jila                          |
|Party Mandal                   |Akola                              |
|Blood Group                    |B+                                 |
And user click on update button

#Scenario: Testing Qc flow in karyakarta data entry
#Given user logged in into the saral application
#|Email|state.adminup2@gmail.com|
#|Password|Test@123|
#|Otp|010203|
#Then user click on sangathan data management card on dashboard
#And user click on add entry button for loksabha karyakarta
#And user select loksabha karyakarta data filter
#|Input Fields           |Input Data       |
#|Loksabha               |- Saharanpur     |
#|Organisation Unit      |Core Sangathan   |
#|Organisation Sub Unit  |Office Bearer    |
#And user scroll to view data table and search for data which need to edit and get all the data
#|Input Fields                   |Edit Input Data                    |
#|Name                           |loksabha Karyakarta Automation Edit|
#|Father Name                    |testautomationedit                 |
#|Designation                    |LSDesigDisplay                     |
#|Phone Number                   |8111112265                         |
#|Has Smartphone                 |No                                 |
#|Primary Member ID              |1234567877                         |
#|Age                            |48                                 |
#|Gender                         |Male                               |
#|WhatsApp Number                |7687984586                         |
#|STD Code                       |6756790                            |
#|Landline Number                |7857787545769                      |
#|Category                       |SC                                 |
#|Caste                          |Pasi                               |
#|Email                          |wardkaryaedit@gamil.com            |
#|Dob                            |02/Jan/1973                        |
#|Full Address                   |Paschim Vihar New Delhi-110065     |
#|Village                        |Demo Village edit                  |
#|Taluka                         |Demo Taluka edit                   |
#|District                       |Aligarh                            |
#|Pin Code                       |110068                             |
#|Education                      |Doctorate                          |
#|Profession                     |Advocate                           |
#|Bike                           |No                                 |
#|Car                            |No                                 |
#|Vidhan Sabha where he/she votes|Nakur                              |
#|Booth where he/she votes       |1                                  |
#|Voter Id                       |63721638190                        |
#|Aadhaar Number                 |732176387190                       |
#|Panna Number                   |9                                  |
#|Ration Card Number             |6376876890                         |
#|Facebook Profile               |abcedit@gmail.com                  |
#|Twitter Profile                |xyzedit@gmail.com                  |
#|Intagram Profile               |tyuiedit@gmail.com                 |
#|Linkedin Profile               |sdghjhjhedit@gmail.com             |
#|Image                          |xyz                                |
#|Salutation                     |Smt                                |
#|Sub Caste                      |qwertedit123                       |
#|Qualification                  |qwertEdit123                       |
#|Religion                       |Hinduism                           |
#|Active Member Id               |647236816381790                    |
#|Party Zila                     |Agra Jila                          |
#|Party Mandal                   |Akola                              |
#|Blood Group                    |B+                                 |	
#And user search for data which need to qc
#And user qc all the data in qc pop up
#And user click on qc done button and verify qc status
#And user verify data in qc edit flow
#And user edit all the data in qc edit flow
























