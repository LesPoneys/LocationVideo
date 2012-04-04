<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form name="firstForm" action="firstFormAction.do" method="post" 
             style="width:50%;margin:auto;background-color:#c1d9fc;padding-bottom:15px;">
		
		<div style="text-align:center;">		
			<h2 style="color:white;background-color:#6683b1;">Formulaire HTML</h2>
			<p>Nom : <input type="text" name="nom" /></p>
			<p>Prenom : <input type="text" name="prenom" /></p>
			<p>Sexe : <input type="radio" name="sexe" value="Masculin" />Masculin 
                                  <input type="radio" name="sexe" value="Féminin" />Féminin</p>
			<p>Couleur de vos yeux : 
				<select name="yeux">
					<option value="Bleu">Bleu</option>
					<option value="Marron">Marron</option>
					<option value="Vert">Vert</option>
				</select>
			</p>
			<p>Vous programmez en :<br >
				<input type="checkbox" name="C" />En C
				<input type="checkbox" name="C++" />En C++
				<input type="checkbox" name="Java" />En Java
				<input type="checkbox" name=".NET" />En .NET
				<input type="checkbox" name="PHP" />En PHP
			</p>
			<p style="width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
		</div>
	</form>

</body>
</html>