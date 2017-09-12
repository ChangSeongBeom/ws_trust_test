package org.wso2.carbon.sts.provider.internal;

import java.util.ArrayList;

import org.apache.cxf.sts.STSPropertiesMBean;
import org.apache.cxf.sts.claims.ClaimsHandler;
import org.apache.cxf.ws.security.tokenstore.TokenStore;

public class DataHolder {
	private static DataHolder dataHolder = new DataHolder();
	private STSPropertiesMBean staticPropertBean;
	private ArrayList<ClaimsHandler> claimHandlerList = new ArrayList<ClaimsHandler>();
	private TokenStore tokenStore;
	
	private DataHolder() {}
	
	public static DataHolder getInstance() {
		return dataHolder;
	}
	
	public void setStaticPropertyBean(STSPropertiesMBean staticPropertyBean) {
		this.staticPropertBean = staticPropertyBean;
	}
	
	public STSPropertiesMBean getStaticPropertyBean() {
		return this.staticPropertBean;
	}

	public void addClaimsHandler(ClaimsHandler claimsHandler) {
		if(!claimHandlerList.contains(claimsHandler)) {
			claimHandlerList.add(claimsHandler);
		}
	}
	
	public ArrayList<ClaimsHandler> getCalimsHandler() {
		return this.claimHandlerList;
	}
	
	public void setTokenStore(TokenStore tokenStore) {
		this.tokenStore = tokenStore; 
	}
	
	public TokenStore getTokenStore() {
		return this.tokenStore;
	}
}