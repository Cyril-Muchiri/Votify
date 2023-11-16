 <div class="card-container">
            <c:forEach var="index" begin="0" end="3">
                <div class="card">
                    <%-- <div class="image">
                        <!-- <img src="person${index + 1}.jpg" alt="Person ${index + 1}" /> -->
                    </div> --%>
                    <%@ page import="com.votifysoft.repository.PersonRepository" %>
                 <c:set var="personName" value="${PersonRepository.getNameAtIndex(index)}" />
                    <h2>${personName}</h2>
                    <p>Total Votes: ${PersonRepository.getVotesForPerson(index)}</p>
                   <c:choose>
           <c:when test="${sessionScope.hasVoted}">
                <form action="./vote" method="post">
                    <input type="hidden" name="personId" value="${index}">
                    <button type="submit" class="vote-btn" disabled>Already Voted</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="./vote" method="post">
                    <input type="hidden" name="personId" value="${index}">
                    <button type="submit" class="vote-btn">Vote</button>
                </form>
   
            </c:otherwise>
        </c:choose>
                </div>
            </c:forEach>
        </div>