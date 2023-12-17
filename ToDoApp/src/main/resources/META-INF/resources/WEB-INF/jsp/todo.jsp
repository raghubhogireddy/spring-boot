<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Enter ToDo details</h1>
    <form:form method="post" modelAttribute="toDo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" name="description" required="required" path="description"/>
            <form:errors path="description" cssClass="text-danger"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" name="targetDate" id="targetDate" required="required" path="targetDate"/>
            <form:errors path="targetDate" cssClass="text-danger"/>
        </fieldset>
        <form:input type="hidden" name="id" path="id"/>
        <form:input type="hidden" name="completed" path="completed"/>
        <input type="submit" class="btn btn-success">
    </form:form>
</div>
<%@include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
</script>