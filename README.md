# repo.ellucian_assignment 
Sample backend application 

tech stack
----------
	-	Springboot
	-	Spring-JMS (Apache ActiveMQ)
	-	Spring Data
	-	Embedded derby db
	
problem
-------
Part 1:

- Develop a program that will invoke the web service at https://jsonplaceholder.typicode.com/posts. This web service should return several posts

- Parse the response to find 25 of them. This component needs to be multi-threaded. If the number of posts are less than 25, retrieve more than 1 post of the result

- Split the posts retrieved and send them to an Apache Active MQ queue. If you retrieved 10 posts, there should be 10 messages sent to the queue

Part 2:

- Develop a consumer that will read the posts from the Apache Active MQ queue

- For each of the posts, split the following values and save them in a database table. You will need to create a database table with the following columns userId and title (please note do not populate the id value into the table). The values that are sent to the database table will be from the message post received from the queue. This should be on a per message basis. In other words, if you sent 10 posts, there should be 10 entries in the database table.	
