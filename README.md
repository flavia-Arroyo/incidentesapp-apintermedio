# <h1 align="center" >Trabajo Integrador - Argentina Programa Intemedio</h1>
<h2 align="center"> Consigna del Trabajo Practico </h2>
<h3 align="center">Sistema de Reporte de Incidentes</h3>
<h5>Contexto general</h5>
<p>Una importante empresa de soporte operativo solicita el diseño y desarrollo de un sistema que le permita la generación y seguimiento de los incidentes que se presentan.
La empresa en cuestión se dedica a brindar soporte operativo sobre distintas aplicaciones (SAP, Tango, etc.) y sistemas operativos (Windows, MacOS, Linux Ubuntu).
El área de RRHH se encarga de realizar las altas, bajas y modificaciones de los técnicos que se encargan de resolver los incidentes reportados.
Cada técnico tiene una o varias especialidades y solo se le pueden asignar incidentes que coincidan con las mismas.
El área comercial es responsable de incorporar nuevos clientes a la empresa. Administra las altas, bajas y modificaciones de los datos de cada uno de ellos.
Finalmente, la mesa de ayuda es responsable de atender las llamadas e ingresar al sistema los incidentes reportados.
</p>
<h5>Ciclo de vida de un incidente</h5>
<p>Cuando un cliente llama, la mesa de ayuda le solicita los datos para identificarlo (razón social, CUIT) y los ingresa en el sistema para que el mismo le muestre los servicios que el cliente tiene contratados.
El operador (de la mesa de ayuda) solicita que le informen por cuál de esos servicios desea reportar un incidente, junto con una descripción del problema y el tipo del problema.
Al ingresar el incidente, el sistema devuelve un listado de técnicos disponibles para resolver el problema. El operador selecciona uno de los técnicos disponibles y el sistema le informa el tiempo estimado de resolución. Luego, informa al cliente que el incidente ha sido ingresado y la fecha posible de resolución.
Al confirmarse el incidente, el sistema debe enviar una notificación al técnico informándole que tiene un nuevo incidente para resolver.
  Cuando el técnico atiende y resuelve el incidente, lo debe marcar como “resuelto”, indicando las consideraciones que crea necesarias. Cuando esto ocurra, el sistema debe enviar un email al cliente informándole que su incidente ya está solucionado.
</p>
<h5>Otros requerimientos</h5>
<p>  ●	El sistema debe permitir al área de RRHH emitir diariamente reportes con los incidentes asignados a cada técnico y el estado de los mismos.
●	El sistema debe permitir que el operador agregue “un colchón” de horas estimadas para la resolución del problema, si el mismo es considerado “complejo”.
●	El sistema debe permitir el alta de incidentes que contengan un conjunto de problemas de un mismo servicio. Dichos problemas deben estar relacionados.
●	El sistema debe dar la posibilidad de informar:
○	Quién fue el técnico con más incidentes resueltos en los últimos N días
○	Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
○	Quién fue el técnico que más rápido resolvió los incidentes
</p>
<h5>Consideraciones</h5>
<p>●	Cada tipo de problema particular puede ser solucionado por una o varias especialidades.
●	Cada operador puede definir, optativamente, su tiempo estimado de resolución por defecto por tipo de problema; el cual tendrá que ser menor al tiempo máximo de resolución definido para el tipo de problema.
●	Cada técnico puede definir su medio preferido de notificación, los cuales pueden ser: Email o WhatsApp. No están definidas las bibliotecas que se utilizarán para realizar estas notificaciones.
</p>
<h5>Metodologia</h5>
<p>Se propone una metodología de trabajo iterativa e incremental. Para esto, el TP se divide en tres entregas, las cuales se realizarán a través del envío del link al repositorio de trabajo por medio del Campus Virtual en la fecha estipulada por el Docente del curso.
En la última entrega (coincidente con la tercera) se deberá exponer el TP frente al curso, mostrando la solución generada y justificando las decisiones tomadas.
</p>

<h2>Entrega 1</h2>
<p>En esta primera iteración nos encargaremos de modelar, a nivel datos y objetos, una solución al dominio presentado. Además, comenzaremos con el proceso de codificación de la solución.

En particular, en esta entrega se solicita:
1.	Modelo de datos (DER en el caso de utilizar conexión con BD) y UML que brinde solución al dominio.
2.	Código con modelado de clases. El código debe estar subido a un repositorio de GitHub.
Es necesario que el proyecto Java sea creado como un proyecto “Maven” para poder añadir algunas dependencias. Se recomienda la utilización de la dependencia de Lombok para facilitar la tarea repetitiva de generación de Setters y Getters de las clases.
</p>

<h4>Diagrama Entidad Relacion</h4>
<img src="https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Copia%20de%20INCIDENTE-APINTERMEDIO.drawio#R7V1dc5s4F%2F41ueyOAYOdy8ZO22ybbSZJ36Z70yGg2Npg5AHy1V%2F%2FCgOOLQks2YAFUiczNTKWsc5zziOdD%2BnEmixeP0fucn6JfBCcmAP%2F9cSanpimMTSG%2BL%2B05S1rcUZW1jCLoJ%2Ff9N5wA%2F%2BAvHGQtz5BH8RbNyYIBQlcbjd6KAyBl2y1uVGEXrZve0DB9rcu3RmgGm48N6Bbf0I%2FmWetY3P03v4FwNm8%2BGbDOc3euXe9x1mEnsL8%2B05M62H1L3t74RZ95T80nrs%2Betloss5PrEmEUJK9WrxOQJCObTFs2ec%2Blby7fu4IhAnPB65%2F3E7Ds7%2Fh5d1%2FF3fT%2BPL5fxePH%2FJent3gKR%2BPSQBxhyB%2F5uStGCf8%2BMv0ZeLep01nceJGSS5Oa4AbsIASF4Ygwg3G6joI3GUMV7dnLXMY%2BN%2FcN%2FSUFB0VV2cP8BX415k003uxYL%2FhztLLtPMH3PlN%2FjDp224AZyF%2B7aXPGqX3gxg%2Fyzc3TvI75skiyF%2FSI1X8bBAl4HWjKR%2B5zwAtQBK94Vvyd09zIb4V4M2vX94hY4zztvkmXIpGN4fpbN31u6jwi1xaApIzKclVi%2Bw6xd7ZHEXwTyqoIB%2FYTTGurl%2FgInBDjHnXJ5rO0ErHV%2BKAQTBBAUplHaIQUOJOb%2FIjtLx1oxlI8oYlgmGyGgf7DP%2FhkZkM%2FrJPbPysE3xtvF%2Fjv%2FT2KJmgME4iDKu0D4Cl%2BwJSCZ8laJl3GoCHov8oH%2Ff09T1KErQoBUClMuxGRQ4DixMFVlMgsCgQXH0thQH%2B%2FQl0g2tsRd1wFmRCWxlV911oDMkyx3o9vuTAk5qK8HA%2BBCvDN4e%2BD7DWnr3MYQJulq6X3vSCeWWXvlZqwG5xbcjHEhRP3tn7oAn35gbYQoVugvUHc0VMyXz9nPvDYEjBwMus%2BMX0yGgo7HR271mMZQ7D2bfskw4BF1sSuLyWa7ddK3y4umsBP7bmEi4uGTTIJc6xucThB0E7tgP4sOivWSKxuWXVdyIZURiIXKziN8jD4padSmQAiHLUMdbUcXTqOD02dZwqSx1jbln1nToKf97mIuQJJuqSBj80%2BkwaT38uP05ff92P7cfF99HT79nP868fDO28Oj5rGGaLtMGGAe2%2Bkp83aHFUQ1wpZmAPBe2eAgsXdnI9Ub%2F0%2B2z82YaKjjlp49%2B68bePvWYQmQNIY%2FzrmRka%2FOLqETewh4KeAvhoAT0YQNRFfmgdIMrRh0n7KPOUhd83IHrG0CkHTgdzF1iAolF0aD6DZXDSgWE0xQem9iTyTwv2iH6OuCEiS3KDSbsVP3Uhu0FYe6v1QWiSMKzV5vP01oLJL76Skd%2Fgyz5J4MlvaB0wr9vi3dTwegHE1V0bCQ4CwW3lyaUxRjl6ioNNzx2lYpRBo6uKtRJoRrHpyWacLx5gpyhFGsQoRymWdmPyUcrOZPya2IU3C8Jsil0s6Tya7a1WrL1cmixVrhKPOLeQvbVhGKSLakq0SBHAiSCj7I8bru7ayOKn7cdF6EFfl2NRoLBHe%2Fov13Cq3foPBdRe%2BfkAp7VYa0R3nJZDOtlBoZKstRLoyOaQLqqBhTXv1hqz2bIsAcj0Odb5Zvx4ufkSTqbgx2f%2F7vJ5cafrsprwWopTSpteSyYKaN91P52WlSqgFKEwR4L2XXcyCCYLXJQjEwHvlCaTpsikzVItJgroVapCZMIvrr6TCb1KTYAXQg9pMtkHLn0mE7bl0wkVErBJqyVc7GemZ6VHth%2BtZfEP90qn6DqbsIeCTqfwQexFcOlBFO4OYkjCLFJgRT0qEdg9QFNJY1Ry9IKw4gFUpJJTbnH1nUpsOq3qAXhzV5OICEr6TCLoJhl%2BTF6%2BPwxOf30Y%2FJp%2FHCRzxj62mkOqOYRCETetlHPIuEUOYcJAwMcpDYVwiaMc9L2mCObPpl2YWI%2B7TRC1Y6DPBMCeN%2BjwhgSrCJM3D6%2B5VYR02bftbWOqZHiDPRSMLYewZvsK7ykhgA71yIMj0Qr4M1CEnbAhnqMZCt3g%2FL01C0xlzGGY2zICof8xPasEX55fY%2BDcoks3fEvBkf4mUDALeIXJXfER%2FPpX2v6XnV9NXzdumxbUg6Uevd1tXmx8Kr18%2F9jqqvgcDZt8yhGjp8gDFaOVj01SUNlJdS5GOnC8xmh9rsbWnhNFYwQCN4HPYOtxK1B3lfLrO56HxKYXQ%2FJsjuyX5596RxnVke1sd2SdEh1lQ0N1hCHgvm3clvN%2F6QPbg%2B3vMfKc0tLnIu63xlv34xfZE%2ByrO%2F%2BdzucX55NgfvXty%2FTs7E%2F8N3JZu7tRulOfZgxENGOnxu6vA4VDXx5wGwS4STPKC%2B7h6HSro1Nyx5e6wE2UcAztHeA2D7u%2F%2BB3NKgMdCPsHJfABem4aCSudfegqnvTaYdV6MXchsmtYPrAFqINRfMtINgSqlULKKh7mIxe2o%2FdVPNVKoNRCkg0EOrAQbhj0bmXL1VbIcyhq%2BrzAZI6NyNYAStMKe2VaE620WcnDhoEq2dfVSqBpxWItmp0g1ZV7%2FGKWvlhXi6aH%2BGXv4e9av90l4pEGV8oRj6mJRwLiabPqhw0DJaJi1RqgWcekWWeVW8flopKEVqQAino0oncikIBGWi33YeNAiUNiq1VA8wjjCAYs2RivVqIVh4BYYRbROxCUL9Q4srRrCBXvDPselGZhnLSUZlFsjLSZZ1G5%2FpUmFj0q4nhFOGdEYI03Fj0ab3fkkLv31RSLJr%2FHGlXHlsn7R0YLiRYWxxwsgCtriScx6BH8zMWdRX4Td9PE%2Bm48X2tM4N6D4ArFMEkXANY0N6WkGU1NGl4lBB%2Fz5gW2nFnUOrOvt2sbTRvc7cnYrvlWqdLsH1seFYZ5Z2y5MecvnRtwHi9BerI69F3%2FNtt%2FoXpafaJaigB5UNGQt8TEqGObZ7YcdYpA7SkCVvdSBAoqUjNFwOIP9vZ9NTSkZ7VgZdcD6Pquolt9HgqaPq%2BNmCcG6%2F10anewiZNKmwkCTBSocj5RpQooRSnMkaBXCglcoqsIYbku3G4lncmCmT4zCnteYmpKOT6lHD30L3IuRc9CNgL1yz1iFPZQ0KH%2FEC3uI7DpgpKdVqRAinI8wtiRSfsqWZAgqkIlcFXqTTE4pwACpsLmx4UsrkrGnhgKuSrV3BaDPRQ92fa7WTel3imjYmx0ImDti0pxRjl6IZOtbh6grfMA10NBu6uzReUELZYBSNTYbelQlCjHIY7erFUCDjm6Y9IRWJz2jEMcfmn1nUMcem0KFi4M1KUOAXCoRx30Ajb3Rf7mcmR30DHJAhWNpEOdlSPe0iJyq7v66ECvLPlnBXtYlSE3QmRxWzqSH3xbNkcQVt5qfRCaIzi1mn2e3tqw%2BvQ6E2xY%2B374LltHDUEEm2pu1jt54OmuDRjRaVWaYcqiYW0wzNHdmA5dyqESw%2FAnM%2FWdYYpiMXpdocllL8AoRy4j2pRQwNmsTAbBPXrZZ%2Ff4RW3bY9e9cfzODeGNfEikKVS2iA3Tx4XbXrRQmSxTdBraEd4kC6Lz7yl9LnKHZWfr%2FmYKlcccwUFdqFy6D%2FqAc1ZUR6Eyc%2BMBxo7%2BNyB6hh7UGX%2Bk43VbdtzHHxnNCU%2B70Q5J%2BatWCCl9Z%2BxHpm1wP1P%2BqpVAqfgaeyho31mcG%2FN%2BLG1aR0yfg27ssdF%2Bs0PyNWqilDadZexHFtj3pLv5GtUaoPmEcTJKlvO3c4kgCadIgRLlOISx9bDmkNY5hDfnr46CNDYMBFanPeMQk19aO6x%2BlXTEOYTsrQ1jIF31wBFZQwAXgqyxP064uqsXKGhxeeMkN9709%2BDq6ufF%2BPrX%2FPEDR6J4fcfy1h9YaW2r2GL1uhmBYR90LNuxpVaZ91v82NLtjiyyo5IITF1QNbsN1bpigPscHt0RpBIH7BrOnkglIV%2Bc0lz7psbE8%2B44PLrkqeqKFDKVhmNrGpmVhrDvjjPaoTarqysQQTxwq4gYty5V7qe4c4dwR7aj2EkdoCYX3GbfIvhjyKdMdSGYY1krM4KbMPuVNfUdhCqBsPWCWdjuk1tZD5qx%2B8Tz2ma13SduHzn12v2p8fgSIPh8Pl%2F8e2651vDpu8eY189R5MbncQIXru%2FGu%2FYX6tOiUDzpgJDYKSsy0HkvIjuBrE1rW3HCCPP8EFM6m8ubl2dKZnLJLDdj37Q8MreqONej6bQ8Ow8FlKblEfcPaz4%2FhCnl6k1ldf2koBUu%2FHbk0TRtFFAy5auPpeCPsFQycqX2SJkCxiZLOlKbpoBNPn01SoEhTyKYsAZX6oRSFS5sNJSdUqF0DeWBoOlzlUtlBYcmmUNLKOshmTaTwtiAYG8tikmmHBh9I5m1UmiWYZSOdPfkimZZRgA1ytGMKejoaaOYcmRZ1f4dfEGGdtr3%2BbBCQlWTHGl8PmR4dezUVYpJxmmbKsUc1VtayVYMev51u2Ffq%2Bdi3fLblOrA%2FuV5Y95NrmqprWQLUOA0FuUn0JxMulaK7vhmGOnQ%2FSzPq1YCpcop2ENBJ0T3b8LcOmr6XF7BHBues%2BE1rZTOrmuilaN7YyzJd0wcNGogLCWrvtlDQVd9w9CDfjrx7hanSAMZ5ThFpEpHc0pTnNLmNv3sR6ZNyZHtRxMle9UaoAnFpLOHfBB7EVx6EIU7%2FU%2BSEIsUUFGPSHRmkgREYvA6P5tbndAJScowyV6JSL1kEouO7Xmr48JmyhxBfShElGMQiw57aQZpn0FsTgYhI671MYhA9KxnDGLxi2uHza%2BSjjiDkL21YQ3o4NmqfOzSfYULdA1iFOBRUpdJBKAiyCT7Q4eru4Owgy8jhJLN2%2FEAzi%2BRD9I7%2Fg8%3D" >





