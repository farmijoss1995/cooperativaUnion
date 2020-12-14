package ec.ups.edu.app.g2.cooperativaUnion.utils;

import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

public class RestFilter implements ContainerRequestFilter {
	public final static String KEY = "AppdI5";

	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		String url = request.getUriInfo().getAbsolutePath().toString();
		if (url.contains("/srv/login"))
			return;
		String token = request.getHeaderString("Authorization");
		System.out.println("TOKEN>>>>" + token);
		if (decodeJWT(token) == null)
			request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
	}

	public static Claims decodeJWT(String jwt) {
		try {
			jwt = jwt.replace("Bearer ", "");
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(jwt)
					.getBody();
			return claims;
		} catch (MalformedJwtException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
