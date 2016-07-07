### Real-Time Progress Bar with Spring MVC + Server-sent events (SSE)

There are cases where we want to show users status of a long term process which has been started on the server. 
To achieve that we usually use a progress bar. I want to expose the implementation of the progress bar with using Server-sent events 
(more ways look at [page](https://spring.io/blog/2012/05/08/spring-mvc-3-2-preview-techniques-for-real-time-updates/)). 
Server-sent events (SSE) is a technology where a client side automaticly receives data from a server via HTTP connection. 
It is enough to monitor a status of a process and to update our progess bar. 

To build the application I use Spring MVC. Scince 4.2 version the SseEmmiter class has been introduced. 
This class makes more easier using of the Server-sent events with Spring.
