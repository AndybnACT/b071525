all:
	javac -cp .:"./lib/*" PriorityQueueTest.java
	java -cp .:"./lib/*" org.junit.runner.JUnitCore  PriorityQueueTest
