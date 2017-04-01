<div>
	<div>
		<h1>Bourse</h1>
	</div>
	<div>
		<form>
			<div class="form-group">
				<select name="indice" id="indice" class="form-group"
					onChange="this.form.submit()" style="width: 250px">
					<c:forEach items="${listeIndices}" var="ind">
						<option value="${ind[0]}">${ind[1]}</option>
					</c:forEach>
				</select>
			</div>
		</form>
		Nom :
		<c:out value="${nom}"></c:out>
		<br /> Change Percent :
		<c:out value="${changePercent}"></c:out>
		<br /> Day High :
		<c:out value="${dayHigh}"></c:out>
		<br /> Day Low :
		<c:out value="${dayLow}"></c:out>
		<br /> Stock Change :
		<c:out value="${stockChange}"></c:out>
		<br /> Stock Volume :
		<c:out value="${stockVolume}"></c:out>
		<br />
	</div>
</div>
