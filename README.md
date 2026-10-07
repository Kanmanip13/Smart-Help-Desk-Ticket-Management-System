##### **Smart Help Desk - Ticket Management System**



A role-based Help Desk Ticket Management System developed using Java, JSP, Servlets, JDBC, MySQL, HTML, and CSS.



The system helps manage support requests by allowing users to create tickets, administrators to assign tickets to support agents, and agents to update ticket status and add comments.



\## Project Overview



The Smart Help Desk system provides a centralized platform for managing technical support tickets.



The application supports three different roles:



\- Admin

\- Agent

\- User



Each role has different permissions based on their responsibilities.



\## Features



\### Authentication

\- User login and logout

\- Session-based authentication

\- Role-based authorization

\- Separate dashboards for Admin, Agent, and User



\### Ticket Management

\- Create tickets

\- View tickets

\- Update ticket status

\- Delete tickets

\- Assign tickets to support agents

\- Track ticket priority

\- Track ticket creator

\- Track assigned agent



\### User Management

\- Create users

\- View users

\- Update user roles

\- Delete users

\- Manage Admin, Agent, and User roles



\### Comment Management

\- Add comments to tickets

\- View ticket comments

\- Delete comments

\- Role-based comment access



\### Knowledge Base

\- Create knowledge-base articles

\- View articles

\- Search articles

\- Update articles

\- Delete articles

\- Categorize support articles



\### Dashboards

\- Admin Dashboard

\- Agent Dashboard

\- User Dashboard

\- Role-specific navigation

\- Ticket and system information



\## User Roles



\### Admin



The Admin has full access to the system.



Admin can:



\- View all tickets

\- Create and manage tickets

\- Assign tickets to agents

\- Manage users

\- Manage comments

\- Manage knowledge-base articles



\### Agent



The Agent handles tickets assigned to them.



Agent can:



\- View assigned tickets

\- Update ticket status

\- Add comments

\- View knowledge-base articles



\### User



The User creates and tracks support requests.



User can:



\- Create tickets

\- View their own tickets

\- Add comments to their tickets

\- View knowledge-base articles



\## Ticket Workflow



```text

USER

&#x20; |

&#x20; | Create Ticket

&#x20; v

ADMIN

&#x20; |

&#x20; | View Ticket

&#x20; | Assign Ticket

&#x20; v

AGENT

&#x20; |

&#x20; | View Assigned Ticket

&#x20; | Update Status

&#x20; | Add Comment

&#x20; v

USER

&#x20; |

&#x20; | View Updated Ticket

&#x20; v

Ticket Completed

