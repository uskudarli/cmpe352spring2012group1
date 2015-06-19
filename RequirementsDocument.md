# REQUIREMENTS DOCUMENT #

This document contains functional and non-functional requirements of the "Social Services Community" project. Contents of this document may change over time upon mutual agreement of customer and contractor (Group1). Please always refer to Google Code for the latest version.

<font color='red'>This documents contains some major updates after its first version dated 13.03.2012, as a result of several feedbacks from the customer and use case analysis. Corrections for Issues #1 have also been made. Some important amendments are colored red. </font>

## 1. FUNCTIONAL REQUIREMENTS ##


### 1.1.  USER TYPES AND ACCESS ###
<font color='red'>1.1.1.</font> There shall be three types of users: MEMBER, GUEST and ADMIN.

1.1.2. By default, MEMBER shall be able to register to the community with a personal invitation code. However, there shall be an administrative option to toggle this setting.

1.1.3. Registration shall include true identity of a MEMBER at least with citizen ID, photo, location information, valid e-mail address and phone number.

1.1.4. Each MEMBER shall login with his/her e-mail address as user id and a password.

<font color='red'>1.1.5.</font> GUEST access shall be possible with anonymous login to a simulated version of the system where GUEST can see a list of recent activities.

1.1.6. There should be different roles for ADMINs (administration, content management).


### 1.2. SERVICES AND COMMUNITY CREDITS ###
1.2.1. SERVICE shall refer to one or more predefined service types for the community.

1.2.2. MEMBERs should be able to discuss and propose new SERVICE types in community forums and poll for them.

<font color='red'>1.2.3.</font> SERVICE shall not involve exchange of money or third-party products in either direction. A so-called virtual "COMMUNITY CREDITS per unit time" shall be the only means of SERVICE compensation.

<font color='red'>1.2.4.</font> Each MEMBER shall have a COMMUNITY CREDITS account upon registration.

1.2.5. There shall not be COMMUNITY CREDITS loans.

1.2.6. ADMINs shall earn COMMUNITY CREDITS for their service.

<font color='red'>1.2.7.</font> COMMUNITY CREDITS transfer shall be atomic, i.e. implemented as a transaction.


### <font color='red'>1.3.</font> SERVICE OFFER ###

<font color='red'>1.3.1.</font> Any MEMBER shall be able to offer SERVICEs belonging to predefined SERVICE types with paying attention to point 1.5.4.

<font color='red'>1.3.2.</font> Each SERVICE entry shall contain at least a title, description of service with location, duration, and time information. SERVICEs shall belong to at least one predefined SERVICE type and have optional additional tags. Moreover, MEMBER shall be able to upload documents and images necessary for local or virtual service entry.

<font color='red'>1.3.3.</font> MEMBERs shall earn a fixed amount of COMMUNITY CREDITS per unit time for whatever SERVICE they offer.

1.3.4. MEMBER shall offer SERVICEs to all of the community, not to a certain individual(s).


### <font color='red'>1.4.</font> SERVICE REQUEST ###

<font color='red'>1.4.1.</font> Any MEMBER shall be able to request a SERVICE with paying attention to point 1.5.4.

1.4.2. MEMBER shall request a SERVICE by submitting a SERVICE request form including his/her message.

1.4.3. Upon approval by the service provider, SERVICE details shall appear on the profile pages of both individuals.

1.4.4. The status of the SERVICE request shall be 'in progress', 'accomplished' or 'not accomplished'.

1.4.5. COMMUNITY CREDITS transaction is committed when the beneficiary marks it as 'accomplished'.


### 1.5. RATING AND ENCOURAGEMENT ###
1.5.1. MEMBER shall be rated by the beneficiary for any SERVICE accomplished with respect to quality of service. Beneficiary shall be able to comment on the SERVICE as well.

1.5.2. MEMBER profile shall be made public with the following information: Links to SERVICEs offered, number of SERVICEs accomplished, up-to-date rating average for quality of service, and current account balance.

1.5.3. The list of up-to-date COMMUNITY CREDITS account balances shall be made available to all community MEMBERs.

<font color='red'>1.5.4.</font> MEMBERs whose balances exceed specified limits (positive or negative) shall be isolated in a publicly available color-mapped balance list and notified to move their balance back towards zero by offering or requesting service.

1.5.5. The system shall also display recent activities in order to promote MEMBERs.

<font color='red'>1.5.6.</font> MEMBERs who stay inactive for a long time should start to lose their credits gradually. This gradual decrease in credits is called DECAY. The speed of the DECAY will increase if the MEMBER continues not to use the system.


### 1.6. SEARCHING FOR SERVICES ###
1.6.1. Any MEMBER shall be able to search for SERVICEs with respect to available SERVICE types or a given search query.

<font color='red'>1.6.2.</font> Tagging of SERVICEs shall be made possible to optimize search.

<font color='red'>1.6.3.</font> Search results shall be retrieved and ranked with respect to relevance to a given search query through a recommender system. Recommender system shall handle the two extreme situations: when there are too many matches or when there is no exact match.

<font color='red'>1.6.4.</font> MEMBERs shall be able to sort listing of the retrieved results at least with respect to location or rating of the offering MEMBER.


### 1.7. SOCIAL NETWORKING ASPECTS ###
<font color='red'>1.7.1.</font> MEMBERs information at different common social networks should be linked to its community account to help him/her socialize.

1.7.2. System should have online/offline messaging capabilities.

<font color='red'>1.7.3.</font> MEMBERs shall be able to like/follow a SERVICE or another MEMBER.


## 2. NON-FUNCTIONAL REQUIREMENTS ##

### 2.1. USABILITY ###
<font color='red'>2.1.1.</font> The system should be easy to use by non-tech savvy people with basic internet usage skills.

<font color='red'>2.1.2.</font> System usage shall be guided by tooltips.

2.1.3. A minimalist web page design should be preferred where applicable.

<font color='red'>2.1.4.</font> Search pages shall be Ajax-based and loaded under 5 seconds with a maximum of 20 results per page, other web pages shall be loaded under 3 seconds with a 1Mbit ADSL connection.

<font color='red'>2.1.5.</font> Web design shall conform to W3C standards.


### <font color='red'>2.2.</font> SECURITY ###
2.2.1. Sensitive information shall not be public. Furthermore, no personal information shall be visible to non-members.

2.2.2. Passwords shall not be under 10 characters and include at least one upper case and one lower case letters. Passwords shall be encrypted using MD5.

2.2.3. User shall log off by clicking a button or by closing the browser.


### 2.3. RELIABILITY ###
<font color='red'>2.3.1.</font> Database should be replicated to compensate for instant failures. RAID level 1 storage system shall be used for this purpose.

<font color='red'>2.3.2.</font> Daily system backup shall be scheduled.


### <font color='red'>2.4.</font> AVAILABILITY ###
<font color='red'>2.4.1.</font> System MTBF (mean time between failures) should be measured and reported during the system test period after deployment on customer site so that periodical system maintenance can be planned.

<font color='red'>2.4.2.</font> Web traffic analysis in point 2.6.1. shall also facilitate maintenance plans.

<font color='red'>2.4.3.</font> System shall work 24/7 with an uptime greater than 95%.


### <font color='red'>2.5.</font> CAPACITY ###
<font color='red'>2.5.1.</font> System shall allow multi-user access up to 1000 people, enough for small/medium-sized communities.

<font color='red'>2.5.2.</font> System shall be allowed to use up to 10 Gbit/sec bandwidth.

<font color='red'>2.5.3.</font> MySQL database system shall be used to handle the required volume of transactions.


### 2.6. COMMUNITY SYSTEM PERFORMANCE ###
<font color='red'>2.6.1.</font> Web traffic analysis shall be made using Google Analytics.

2.6.2. Social network performance should be measured based on points 1.5.4 and 1.7.3. (to be further discussed with customer)


### 2.7. DEPENDABILITY ###
<font color='red'>2.7.1.</font> Project shall be designed to run problem free on latest versions of Mozilla Firefox, Google Chrome, and Internet Explorer web browsers as of April, 01, 2012.

2.7.2. The project shall be implemented using standard Java SE7 and run on Apache Tomcat Server 6.0 on customer’ s site.

2.7.3. Progress of project shall be monitored by customer and contractor via Google code.