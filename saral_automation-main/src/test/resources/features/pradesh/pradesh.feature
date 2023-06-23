Feature: Testing data entry for pradesh level

Background:
Given user logged in into the saral application
|Email|saradastate.admin@gmail.com|
|Password|Sarada@123|
|Otp|010203|
@Add/Edit_Data
Scenario: Testing pradesh add data and edit entry entire functionality
Then user click on sangathan data management card on dashboard
And user click on add entry button for pradesh
And user select pradesh data filter
|Input Fields           |Input Data       |
|pradesh                |Bihar            |
|Organisation Unit      |Core Sangathan   |
|Organisation Sub Unit  |Office Bearer    | 
And user click on search button and verify pradesh filter text
And user clicks on enter more details
Then user input below details in data entry form with input fields validation
|Input Fields                   |Input Data                    |
|Name                           |pradesh Automation            |
|Father Name                    |testautomation                |
|Designation                    |Secretary                     |
|Phone Number                   |8111112234                    |
|Has Smartphone                 |Yes                           |
|Primary Member ID              |1234567876                    |
|Age                            |45                            |
|Gender                         |Female                        |
|WhatsApp Number                |7687984587                    |
|STD Code                       |6756768                       |
|Landline Number                |7857787545767                 |
|Category                       |OBC                           |
|Caste                          |Agri                          |
|Email                          |pradeshkarya@gamil.com        |
|Dob                            |02/Jan/1972                   |
|Full Address                   |Paschim Vihar New Delhi-110063|
|Village                        |Demo Village                  |
|Taluka                         |Demo Taluka                   |
|District                       |Araria                        |
|Pin Code                       |110067                        |
|Education                      |Post Graduate                 |
|Profession                     |Teacher                       |
|Bike                           |Yes                           |
|Car                            |Yes                           |
|Vidhan Sabha where he/she votes|1 - Valmiki Nagar             |
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
|Party Zila                     |Arwal                         |
|Party Mandal                   |Karpi                         |
|Blood Group                    |A+                            |
And user click on add button
And user click on edit button for recently added entry
And user verify all the added data
#When user enter data with duplicate phone which is already exist on given data level, unit, and subunit
Then user edit all the added data with new data
|Input Fields                   |Edit Input Data                |
|Name                           |pradesh Automation Edit        |
|Father Name                    |testautomationedit             |
|Designation                    |Secretary                      |
|Phone Number                   |8111112235                     |
|Has Smartphone                 |No                             |
|Primary Member ID              |1234567877                     |
|Age                            |48                             |
|Gender                         |Male                           |
|WhatsApp Number                |7687984586                     |
|STD Code                       |6756790                        |
|Landline Number                |7857787545769                  |
|Category                       |SC                             |
|Caste                          |Balai                          |
|Email                          |pradesh@gamil.com              |
|Dob                            |02/Jan/1973                    |
|Full Address                   |Paschim Vihar New Delhi-110065 |
|Village                        |Demo Village edit              |
|Taluka                         |Demo Taluka edit               |
|District                       |Arwal                          |
|Pin Code                       |110068                         |
|Education                      |Doctorate                      |
|Profession                     |Advocate                       |
|Bike                           |No                             |
|Car                            |No                             |
|Vidhan Sabha where he/she votes|                               |
|Booth where he/she votes       |1                              |
|Voter Id                       |63721638190                    |
|Aadhaar Number                 |732176387190                   |
|Panna Number                   |9                              |
|Ration Card Number             |6376876890                     |
|Facebook Profile               |abcedit@gmail.com              |
|Twitter Profile                |xyzedit@gmail.com              |
|Intagram Profile               |tyuiedit@gmail.com             |
|Linkedin Profile               |sdghjhjhedit@gmail.com         |
|Image                          |xyz                            |
|Salutation                     |Smt                            |
|Sub Caste                      |qwertedit123                   |
|Qualification                  |qwert123                       |
|Religion                       |Hinduism                       |
|Active Member Id               |647236816381790                |
|Party Zila                     |Baanka                         |
|Party Mandal                   |Barhat                         |
|Blood Group                    |B+                             |
And user click on update button
 
@Test_with_few_data
Scenario: testing pradesh add and edit data functionality with only primary fields
Then user click on sangathan data management card on dashboard
And user click on add entry button for pradesh
And user select pradesh data filter
|Input Fields           |Input Data       |
|pradesh                |Bihar            |
|Organisation Unit      |Core Sangathan   |
|Organisation Sub Unit  |Office Bearer    | 
And user click on search button and verify pradesh filter text
Then user input primary details in the data entry form
|Input Fields                   |Input Data                    |
|Name                           |pradesh Automation            |
|Father Name                    |testautomation                |
|Designation                    |Secretary                     |
|Phone Number                   |8111112234                    |
|Has Smartphone                 |Yes                           |
|Primary Member ID              |1234567876                    |
|Age                            |45                            |
And user click on add button
And user click on edit button for recently added entry
And user verify primary details in the data entry form
When user enter data with duplicate phone which is already exist on given data level, unit, and subunit
And user enter data with duplicate phone number which is already exist on different data level , unit and subunit
|Duplicate Phone Number|8889035101|
Then user edit primary details in the data entry form
|Input Fields                   |Edit Input Data                |
|Name                           |pradesh Automation Edit        |
|Father Name                    |testautomationedit             |
|Designation                    |Secretary                      |
|Phone Number                   |8111112235                     |
|Has Smartphone                 |No                             |
|Primary Member ID              |1234567877                     |
|Age                            |48                             |
And user click on update button 
























