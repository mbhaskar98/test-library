
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNTestLibrarySpec.h"

@interface TestLibrary : NSObject <NativeTestLibrarySpec>
#else
#import <React/RCTBridgeModule.h>

@interface TestLibrary : NSObject <RCTBridgeModule>
#endif

@end
