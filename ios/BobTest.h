
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNBobTestSpec.h"

@interface BobTest : NSObject <NativeBobTestSpec>
#else
#import <React/RCTBridgeModule.h>

@interface BobTest : NSObject <RCTBridgeModule>
#endif

@end
