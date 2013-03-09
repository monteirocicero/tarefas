<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="false" %>

<input type="text" id="${id}" name="${name}" value="${value}"/>
<script type="text/javascript">
	$(function() {		
		$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});		
	});
</script>

