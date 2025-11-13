# Add project specific ProGuard rules here.
# By default, the flags in the AOSP rules file are used.
# See http://developer.android.com/tools/help/proguard.html for more details.

# If your project uses the Compose UI, you need to add these rules:
-keepclassmembers class * {
    @androidx.compose.runtime.Composable <methods>;
}
-keep class androidx.compose.ui.tooling.ComposeViewAdapter {
    <init>(...);
}
