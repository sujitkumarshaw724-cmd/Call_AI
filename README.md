# Call AI Assistant — Android 14 prototype

This project targets Android 14+ and is designed as a **safe, honest prototype** for an AI-assisted phone-call workflow.

## What works
- Call Screening role request using Android Telecom APIs.
- Default Phone/Dialer role request.
- Incoming call detection through `CallScreeningService` / `InCallService` when the user grants the corresponding role.
- Caller number capture where Android exposes it.
- Save a per-call instruction such as: `Bolo main 20 minute mein call karunga.`
- Call answer/disconnect hooks in `InCallService`.
- Android Text-to-Speech hook for speaking the instruction.
- Notification when a call arrives/ends.

## Important limitation
A normal third-party Android app cannot be promised unrestricted access to the cellular call's two-way audio stream. Android's public Telecom APIs expose call control and screening, but they do **not** provide a universal API that lets an ordinary app transparently replace the caller's audio with an arbitrary AI voice.

Therefore this repository deliberately does **not** claim that it can silently turn every cellular call into a full autonomous AI conversation. Full two-way AI conversation requires a supported audio path (for example a VoIP/SIP call controlled by the app, or device/carrier-specific capabilities). The app can still serve as the call-control/screening foundation.

## Build
Use JDK 17 and Gradle 8.13 (Android Gradle Plugin 8.13.0).

GitHub Actions workflow is included.

## Test on Redmi 10 / Android 14
1. Install the debug APK.
2. Open the app.
3. Grant microphone and notification permission.
4. Tap **Enable Call Screening** and accept the system role dialog.
5. For call-control features, tap **Make this app Default Phone** and accept the system role dialog.
6. Save your instruction.
7. Test with a non-emergency call.

Do not test automation on emergency calls.
