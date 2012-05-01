INSERT INTO CATEGORIE VALUES(9,'Action',NULL)
COMMIT
INSERT INTO CATEGORIE VALUES(10,'Aventure',NULL)
COMMIT
INSERT INTO CATEGORIE VALUES(11,'Com�die',NULL)
COMMIT
INSERT INTO CATEGORIE VALUES(12,'Horreur',NULL)
COMMIT
INSERT INTO CATEGORIE VALUES(13,'Science Fiction',NULL)
COMMIT

INSERT INTO SUPPORT VALUES(5,'DVD')
COMMIT
INSERT INTO SUPPORT VALUES(6,'Blu-Ray')
COMMIT
INSERT INTO SUPPORT VALUES(7,'VOD')

INSERT INTO VIDEO VALUES(1,'2012-05-01 17:13:27.051000000','Au royaume d''Asgard, Thor est un guerrier aussi puissant qu''arrogant dont les actes t�m�raires d�clenchent une guerre ancestrale. Banni et envoy� sur Terre, par son p�re Odin, il est condamn� � vivre parmi les humains. Mais lorsque les forces du mal de son royaume s''appr�tent � se d�cha�ner sur la Terre, Thor va apprendre � se comporter en v�ritable h�ros...','http://www.videofutur.fr/img/fr_FR/457x640/10005735.jpg','Thor',1.5,13)
INSERT INTO VIDEO_SUPPORT VALUES(1,5)
INSERT INTO VIDEO_SUPPORT VALUES(1,6)
COMMIT
INSERT INTO VIDEO VALUES(2,'2012-05-01 17:14:18.151000000','Jeanne est la doubleuse fran�aise d''une actrice am�ricaine qui joue dans une s�rie t�l� � succ�s. Mais le jour o� l''actrice am�ricaine p�te les plombs et annonce la fin de sa carri�re, la vie de Jeanne bascule � son tour. Plus de travail, plus de revenu, plus rien. A moins que... A moins qu''elle ne prenne son destin en mains et ne tente a priori l''impossible : partir � Los Angeles, rencontrer la star am�ricaine et la convaincre de reprendre la direction des plateaux de tournage...','http://www.videofutur.fr/img/fr_FR/457x640/10006414.jpg','Hollywoo',10,11)
INSERT INTO VIDEO_SUPPORT VALUES(2,6)
INSERT INTO VIDEO_SUPPORT VALUES(2,5)
COMMIT
INSERT INTO VIDEO VALUES(3,'2012-05-01 17:15:17.340000000','C''�tait bien avant que notre mythique Chat Pott� ne croise la route de Shrek... Le l�gendaire f�lin, et non moins redoutable amant, s''�tait alors embarqu� dans un p�riple riche en rebondissements, avec la ravissante et rus�e Kitty Pattes de Velours et Humpty Alexandre Dumpty, v�ritable ''cerveau'' de l''op�ration. Leur objectif : s''emparer de la fameuse Oie aux oeufs d''Or pour sauver la ville o� le Chat Pott� a grandi. Voici l''histoire v�ridique du Chat, du Mythe, de la L�gende et... des Bottes !','http://www.videofutur.fr/img/fr_FR/457x640/10006628.jpg','Le chat pott�',2.9,11)
INSERT INTO VIDEO_SUPPORT VALUES(3,6)
INSERT INTO VIDEO_SUPPORT VALUES(3,7)
COMMIT
INSERT INTO VIDEO VALUES(4,'2012-05-01 17:16:22.249000000','Paris, ann�es 60. Jean-Louis Joubert, agent de change rigoureux et p�re de famille coinc�, d�couvre qu''une joyeuse cohorte de bonnes espagnoles vit... au sixi�me �tage de son immeuble bourgeois. Maria, la jeune femme qui travaille sous son toit, lui fait d�couvrir un univers exub�rant et folklorique � l''oppos� des mani�res et de l''aust�rit� de son milieu.','http://www.videofutur.fr/img/fr_FR/457x640/10005376.jpg','Les femmes du 6eme etage',5,11)
INSERT INTO VIDEO_SUPPORT VALUES(4,6)
COMMIT
INSERT INTO VIDEO VALUES(5,'2012-05-01 17:18:07.968000000','Dans le Paris des ann�es 30, le jeune Hugo est un orphelin de douze ans qui vit dans une gare. Son pass� est un myst�re et son destin une �nigme. De son p�re, il ne lui reste qu''un �trange automate dont il cherche la cl� - en forme de coeur - qui pourrait le faire fonctionner. En rencontrant Isabelle, il a peut-�tre trouv� la cl�, mais ce n''est que le d�but de l''aventure...','http://www.videofutur.fr/img/fr_FR/457x640/10006700.jpg','Hugo cabret',6.9,10)
INSERT INTO VIDEO_SUPPORT VALUES(5,5)
COMMIT
INSERT INTO VIDEO VALUES(6,'2012-05-01 17:20:03.672000000','Parce qu''il ach�te la maquette d''un bateau appel� la Licorne, Tintin, un jeune reporter, se retrouve entra�n� dans une fantastique aventure � la recherche d''un fabuleux secret. En enqu�tant sur une �nigme vieille de plusieurs si�cles, il contrarie les plans d''Ivan Ivanovitch Sakharine, un homme diabolique convaincu que Tintin a vol� un tr�sor en rapport avec un pirate nomm� Rackham le Rouge.','http://www.videofutur.fr/img/fr_FR/457x640/10006393.jpg','Les aventures de Tintin : le secret de la licorne',8,9)
INSERT INTO VIDEO_SUPPORT VALUES(6,6)
INSERT INTO VIDEO_SUPPORT VALUES(6,5)
COMMIT
INSERT INTO VIDEO VALUES(7,'2012-05-01 17:21:05.505000000','A la suite d''un accident de parapente, Philippe, riche aristocrate, engage comme aide � domicile Driss, un jeune de banlieue tout juste sorti de prison. Bref la personne la moins adapt�e pour le job. Ensemble ils vont faire cohabiter Vivaldi et Earth Wind and Fire, le verbe et la vanne, les costumes et les bas de surv�tement... Deux univers vont se t�lescoper, s''apprivoiser, pour donner naissance � une amiti� aussi dingue, dr\u00f4le et forte qu''inattendue, une relation unique qui fera des �tincelles et qui les rendra... intouchables...','http://www.videofutur.fr/img/fr_FR/457x640/10006536.jpg','Intouchables',3.5,11)
INSERT INTO VIDEO_SUPPORT VALUES(7,6)
COMMIT
INSERT INTO VIDEO VALUES(8,'2012-05-01 17:21:57.034000000','L''�l�ve Ducobu s''est encore fait renvoyer d''une �cole. Cette fois, pour �viter de finir en pension, il n''a plus qu''une seule chance : r�ussir � Saint-Potache. Pour s''en sortir, ce cancre attachant va devoir se surpasser et mettre au point les tricheries les plus ing�nieuses et les plus spectaculaires jamais imagin�es. La partie est loin d''�tre gagn�e car Mr Latouche, son redoutable professeur, est un adversaire coriace et L�onie, la premi�re de la classe sur qui il tente de copier, ne va pas rester longtemps sous son charme...','http://www.videofutur.fr/img/fr_FR/457x640/10006030.jpg','L''Eleve Ducobu',6,11)
INSERT INTO VIDEO_SUPPORT VALUES(8,5)
COMMIT
INSERT INTO VIDEO VALUES(9,'2012-05-01 17:23:07.719000000','Bella a fait son choix : elle s''appr�te � �pouser Edward. Mais le jeune homme honorera-t-il sa part du march� ? Acceptera-t-il de la transformer en vampire et de la voir renoncer � sa vie humaine ?','http://www.videofutur.fr/img/fr_FR/457x640/10006249.jpg','Twilight - Chapitre  IV : R�v�lation',7,12)
INSERT INTO VIDEO_SUPPORT VALUES(9,7)
INSERT INTO VIDEO_SUPPORT VALUES(9,5)
COMMIT
INSERT INTO VIDEO VALUES(10,'2012-05-01 17:24:21.022000000','Dans cette histoire pleine d''action, o� v�rit�, trahison, jeunesse �ternelle et mort forment un cocktail explosif, le capitaine Jack Sparrow retrouve une femme qu''il a connue autrefois. Leurs liens sont-ils faits d''amour ou cette femme n''est-elle qu''une aventuri�re sans scrupules qui cherche � l''utiliser pour d�couvrir la l�gendaire Fontaine de Jouvence ? Lorsqu''elle l''oblige � embarquer � bord du Queen Anne''s Revenge, le bateau du terrible pirate Barbe-Noire, Jack ne sait plus ce qu''il doit craindre le plus : le redoutable ma�tre du bateau ou cette femme surgie de son pass�...','http://www.videofutur.fr/img/fr_FR/457x640/10005785.jpg','Pirates des caraibes : la fontaine de jouvence',10,13)
INSERT INTO VIDEO_SUPPORT VALUES(10,7)
INSERT INTO VIDEO_SUPPORT VALUES(10,5)
INSERT INTO VIDEO_SUPPORT VALUES(10,6)
COMMIT
INSERT INTO VIDEO VALUES(11,'2012-05-01 17:26:17.657000000','Le jeune s�minariste am�ricain Michael Kovak se rend au Vatican pour y �tudier les rites de l''exorcisme. F�ru de psychologie, il nourrit de s�rieux doutes � l''�gard de ces pratiques anciennes, et juge que la \u00abpossession\u00bb rel�ve de la psychiatrie plut\u00f4t que de la d�monologie. Il se heurte p�riodiquement � ses formateurs jusqu''au jour o� ceux-ci l''adressent au P�re Lucas, eccl�siastique l�gendaire qui a pratiqu� avec succ�s des centaines d''exorcismes. Au contact de ce mentor au comportement abrupt et d�routant, Michael commence � se d�prendre de ses pr�jug�s. Un cas se pr�sente bient\u00f4t � lui, dont la violence terrifiante va le forcer � se remettre en question...','http://www.videofutur.fr/img/fr_FR/457x640/10005621.jpg','Le rite',7,12)
INSERT INTO VIDEO_SUPPORT VALUES(11,6)
INSERT INTO VIDEO_SUPPORT VALUES(11,5)
COMMIT
INSERT INTO VIDEO VALUES(12,'2012-05-01 17:27:08.129000000','Officiellement, Apollo 17 fut le dernier voyage sur la lune organis� par la Nasa en 1972. La mission Apollo 18, ''annul�e pour des raisons budg�taires'', a en fait eu lieu secr�tement l''ann�e suivante. Les images qui en furent rapport�es, et qui ont �t� retrouv�es, r�v�lent une r�alit� que la NASA essaie de nous cacher depuis 40 ans... C''est pour �a qu''aucun autre astronaute n''y est retourn� depuis cette �poque.','http://www.videofutur.fr/img/fr_FR/457x640/10006182.jpg','Apollo 18',6,12)
INSERT INTO VIDEO_SUPPORT VALUES(12,6)
INSERT INTO VIDEO_SUPPORT VALUES(12,5)
COMMIT
INSERT INTO VIDEO VALUES(13,'2012-05-01 17:28:01.523000000','Dans ce cinqui�me �pisode, la Mort est toujours aussi omnipr�sente et se d�cha�ne apr�s qu''un homme soit victime d''une terrible pr�monition, laquelle permet de sauver ses coll�gues de l''effondrement d''un pont suspendu. Ce groupe d''\u00e2mes innocentes n''�tait pas suppos� survivre, et, dans une course terrifiante contre le temps, ces malheureux tentent fr�n�tiquement de trouver le moyen d?�chapper au sinistre agenda de la Mort.','http://www.videofutur.fr/img/fr_FR/457x640/10006095.jpg','Destination Finale 5',5,12)
INSERT INTO VIDEO_SUPPORT VALUES(13,5)
INSERT INTO VIDEO_SUPPORT VALUES(13,6)
COMMIT

