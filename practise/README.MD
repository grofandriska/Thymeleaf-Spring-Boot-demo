
2020.06.07. DevLog:
-----------------------------------------------------------------------------------------------------------------

Since PersonRepository(~PM,Message,etc...) extends JPARepository its implements all it's methods. These methods invoked inside MessageService
class.

As current state it's saving data to H2 and every stop flushes the database - I believe it will work out on kubernetes alltho' 
a saved Database would benefit .

Classes:
-------

Person -> Main user object
----------------------------------------------------------------------------------------------------------------
Message -> main message object
-----------------------------------------------------------------------------------------------------------------
Direct Message -> Message with sender and receiver id
-----------------------------------------------------------------------------------------------------------------
PM -> Simple SwitchTable for Messages for User based on id (save user_id in message ? remove this table)
-----------------------------------------------------------------------------------------------------------------
    
Tables:
-------

direct_message (id bigint not null, message varchar(255), receiver_id bigint, sender_id bigint, primary key (id))
--------------------------------------------------------------------------------------------------
message (id bigint not null, message varchar(255), primary key (id))
-----------------------------------------------------------------------------------------------------------------
person (id bigint not null, age integer not null, name varchar(255), primary key (id))
-----------------------------------------------------------------------------------------------------------------
pm (id bigint not null, message_id bigint, person_id bigint, primary key (id))
-----------------------------------------------------------------------------------------------------------------


 

