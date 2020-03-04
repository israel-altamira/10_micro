package com.example.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info(String.format("POST - Metodo [%s] Request [%s]", request.getMethod(), request.getRequestURL().toString()));

		long tiempoInicio = (Long)request.getAttribute("tiempoInicio");
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoFinal - tiempoInicio;

		log.info(String.format("tiempo transcurrido [%s]milisengundos", tiempoTranscurrido));
		
		return new String("probando el tipo de respuesta del filtro POST");
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

}
