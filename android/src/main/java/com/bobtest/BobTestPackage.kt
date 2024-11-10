package com.bobtest

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.NativeModule
import com.facebook.react.module.model.ReactModuleInfoProvider
import com.facebook.react.module.model.ReactModuleInfo
import java.util.HashMap

class BobTestPackage : TurboReactPackage() {
  override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
    return if (name == BobTestModule.NAME) {
      BobTestModule(reactContext)
    } else {
      null
    }
  }

  override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
    return ReactModuleInfoProvider {
      val moduleInfos: MutableMap<String, ReactModuleInfo> = HashMap()
      val isTurboModule: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
      moduleInfos[BobTestModule.NAME] = ReactModuleInfo(
        BobTestModule.NAME,
        BobTestModule.NAME,
        false,  // canOverrideExistingModule
        false,  // needsEagerInit
        true,  // hasConstants
        false,  // isCxxModule
        isTurboModule // isTurboModule
      )
      moduleInfos
    }
  }
}
