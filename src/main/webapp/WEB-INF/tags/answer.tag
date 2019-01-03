<%-- 
    Document   : answer
    Created on : 3 gen 2019, 11:21:57
    Author     : didacus
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="answer" type="it.blackhat.symposium.models.AnswerModel"%>

<section class="media-object">
    <div class="media-object-section">
        <div class="thumbnail">
            <i class="fi-torso"></i>
        </div>
    </div>
    <div class="media-object-section">
        <p>
            ${answer.content}
        </p>
    </div>
</section>