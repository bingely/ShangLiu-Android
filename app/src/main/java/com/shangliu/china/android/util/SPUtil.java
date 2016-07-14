package com.shangliu.china.android.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
	private static final String TAG = SPUtil.class.getSimpleName();
	private static final String NAME = "setttings";
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	private Context context;
	private static SPUtil util;
	
	private SPUtil(Context context) {
		this.context = context;
		sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		editor = sp.edit();
	}
	
	public static SPUtil getDefault(Context context) {
		if (util == null) {
			util = new SPUtil(context);
		}
		return util;
	}

	public void setPwd(String pwd) {
		editor.putString("pwd", pwd);
		editor.commit();
	}

	public String getPwd(){
		return sp.getString("pwd","");
	}

	// 类似于这种保存
	
	/*public void setWidth(int width) {
		editor.putInt("width", width);
		editor.commit();
	}
	
	public int getWidth() {
		return sp.getInt("width", 0);
	}*/


	// 保存TODKEN、保存在一个配置文件东西上

	/***
	 * 
	 *
	 * 
	 * */
	/*public void saveStore(StoreInfo store) {
		String jsonStore = sp.getString("store", "");
		
		Gson gson = new Gson();
		ArrayList<StoreInfo> storeList = gson.fromJson(jsonStore, new TypeToken<List<StoreInfo>>() {}.getType());
		
		int index = 0;
		if(storeList!=null){
			for(StoreInfo storeinfo: storeList){
				if(storeinfo.storeId.equals(store.storeId)){
					storeList.remove(index);
					storeList.add(store);
					break;
				}
				index++;
			}
		}else{
			storeList = new ArrayList<StoreInfo>();
			storeList.add(store);
		}
		
		if(!storeList.contains(store)){
			storeList.add(store);
		}
		
		String jsonArr = gson.toJson(storeList);
		
		editor.putString("store", jsonArr);
		editor.commit();
	}
	
	*//***
	 * 
	 * 获取门店信息列表
	 * 
	 * @author bob
	 * *//*
	public ArrayList<StoreInfo> getStoreList() {
		String jsonStore = sp.getString("store", "");
		Gson gson = new Gson();
		ArrayList<StoreInfo> storeList = gson.fromJson(jsonStore, new TypeToken<List<StoreInfo>>() {}.getType());
		return storeList;
	}
	
	*//**
	 * 清除门店信息列表
	 *//*
	public void removeStorelt(){
		editor.remove("store");
		editor.commit();
	}
	
//	public void saveLoginEntity(String username, String token, Store store) {
//		LoginEntity entity = new LoginEntity(username, token, store);
//		
//		File file = new File(context.getFilesDir(), "logininfo"); 
//		if (file.exists()) {
//			LogUtil.d(TAG, file.getName() + " exists");
//		} else {
//			LogUtil.d(TAG, file.getName() + " is not exists");
//		}
//		FileOutputStream output = null;  
//		ObjectOutputStream out = null; 
//		try {
//			output = new FileOutputStream(file);
//			out = new ObjectOutputStream(output); 
//			out.writeObject(entity);		
//		} catch (IOException e) {
//			e.printStackTrace();
//			LogUtil.e(TAG, "saveLoginEntity save failed");
//		} finally {
//			try {
//				if (out != null) {
//					out.close();
//				}
//				if (output != null) {
//					output.close();
//				}
//			} catch (IOException e) {
//				LogUtil.e(TAG, "saveLoginEntity close failed");
//			}
//		}
//	}
	
	public void clearToken() {
		File file = new File(context.getFilesDir(), "logininfo");
		if (file.exists()) {
			file.delete();
		}
	}
	
	public LoginEntity getLoginToken() {
		File file = new File(context.getFilesDir(), "logininfo"); 
		if (!file.exists())  {
			LogUtil.d(TAG, file.getName() + " is not exists");
			return null;
		}
		
		FileInputStream input = null;
		ObjectInputStream in = null;
		LoginEntity entity = null;
		try {
			input = new FileInputStream(file);
			in = new ObjectInputStream(input) ;
			entity = (LoginEntity)in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.e(TAG, "getLoginEntity save failed");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				LogUtil.e(TAG, "getLoginEntity close failed");
			}
		}
		
		return entity;
	}	
	
	public void clearLoginInfo(){
		editor.remove("login_pwd");
		editor.remove("id");
		editor.commit();	
	}*/
}
