package com.bobtest

import com.facebook.react.bridge.ReactApplicationContext

abstract class BobTestSpec internal constructor(context: ReactApplicationContext) :
  NativeBobTestSpec(context) {
}
