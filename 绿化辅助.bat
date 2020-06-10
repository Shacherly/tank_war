@ECHO OFF & CD /D %~DP0 
>NUL 2>&1 REG.exe query "HKU\S-1-5-19" || (
    ECHO SET UAC = CreateObject^("Shell.Application"^) > "%TEMP%\Getadmin.vbs"
    ECHO UAC.ShellExecute "%~f0", "%1", "", "runas", 1 >> "%TEMP%\Getadmin.vbs"
    "%TEMP%\Getadmin.vbs"
    DEL /f /q "%TEMP%\Getadmin.vbs" 2>NUL
    Exit /b
)
:Menu
echo.&echo +.创建桌面歪歪语音
echo.&echo 1.屏蔽并阻止后台下载YY浏览器、所有游戏相关等其它推荐应用
echo.&echo 2.卸载并彻底清理所有已下载的推荐应用组件及后台缓存等数据
echo.&echo  提示：先清理，再屏蔽！记得以后清理之后，请重新屏蔽一次！
echo.&echo.
set /p a=输入数字回车：
IF NOT "%a%"=="" SET a=%a:~0,1%
if "%a%"=="+" Goto DesktopLnk
if "%a%"=="1" Goto StopDownFile
if "%a%"=="2" Goto StartDownFile
echo.&echo 输入无效，请重新输入！ 
PAUSE >NUL & CLS & GOTO Menu

:StopDownFile
taskkill /f /im YY* >NUL 2>NUL
taskkill /f /im Ilc* >NUL 2>NUL
taskkill /f /im adb.exe >NUL 2>NUL

del/f/s/q "%AppData%\duowan\*" >NUL 2>NUL
rd/s/q "%AppData%\duowan" 2>NUL
rd/s/q "%CommonProgramFiles%\duowan"2>NUL
rd/s/q "%CommonProgramFiles(x86)%\duowan"2>NUL
reg delete  HKCU\Software\duowan /f>NUL 2>NUL

start /wait /B "" "%~dp08.57.0.1\yyrun.exe" -reg

md "%AppData%\duowan\yy\business" 2>NUL
md "%AppData%\duowan\yy\yycomstore\2052" 2>NUL
md "%AppData%\duowan\yy\openplatform\addons\platform" 2>NUL

echo. >"%AppData%\duowan\yy\setup" 2>NUL
echo. >"%AppData%\duowan\yy\update" 2>NUL
echo. >"%AppData%\duowan\yygame" 2>NUL
echo. >"%AppData%\duowan\gamebox" 2>NUL
echo. >"%AppData%\duowan\YYExplorer" 2>NUL
echo. >"%AppData%\duowan\yy\yyapkinst" 2>NUL
echo. >"%AppData%\duowan\yyedownloader" 2>NUL
echo. >"%AppData%\duowan\yygamestore" 2>NUL
echo. >"%AppData%\duowan\phonetreasure" 2>NUL
echo. >"%AppData%\duowan\yy\business\gameproxy" 2>NUL
echo. >"%AppData%\duowan\yy\business\gamesmilies" 2>NUL
echo. >"%AppData%\duowan\yy\openplatform\aggame" 2>NUL
echo. >"%AppData%\duowan\yy\openplatform\addons\platform\20011" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.apppush" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.apphelper" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.bzAssistant" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamepk" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gameHall" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gameproxy" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gameteam" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamestore" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamewonder" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamewakuang" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamechannel" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamechannelbaby" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamecard" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamelivecard" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.garbagecleaner" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamenotify" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamesmilies" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.gamewakuang" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.kuaikuai" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.yycgame" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.phonetreasure" 2>NUL
echo. >"%AppData%\duowan\yy\yycomstore\2052\com.yy.logingiftbag" 2>NUL

attrib +r "%AppData%\duowan\phonetreasure" 2>NUL
attrib +r "%AppData%\duowan\yy\setup">NUL 2>NUL
attrib +r "%AppData%\duowan\yy\update">NUL 2>NUL
attrib +r "%AppData%\duowan\yygame">NUL 2>NUL
attrib +r "%AppData%\duowan\gamebox">NUL 2>NUL
attrib +r "%AppData%\duowan\yy\business">NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yyapkinst">NUL 2>NUL
attrib +r "%AppData%\duowan\yygamestore">NUL 2>NUL
attrib +r "%AppData%\duowan\yyedownloader">NUL 2>NUL
attrib +r "%AppData%\duowan\yy\cache\wonderworld" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\cache\download\constancy">NUL 2>NUL
attrib +r "%AppData%\duowan\yyedownloader">NUL 2>NUL
attrib +r "%AppData%\duowan\yy\business\gameproxy" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\business\gamesmilies" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\openplatform\aggame" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\openplatform\addons\platform\20011" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.apppush" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.apphelper">NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.bzAssistant">NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamepk" 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gameHall" 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gameproxy" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamestore" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gameteam" 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamewonder" 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamewakuang" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamechannel" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamechannelbaby" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamenotify" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamesmilies" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamewakuang" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.kuaikuai" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.yycgame" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamecard" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.gamelivecard" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.garbagecleaner" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.phonetreasure" >NUL 2>NUL
attrib +r "%AppData%\duowan\yy\yycomstore\2052\com.yy.logingiftbag" >NUL 2>NUL
SET E=完成!&GOTO MSGBOX

:StartDownFile
taskkill /f /im YY* >NUL 2>NUL
taskkill /f /im Ilc* >NUL 2>NUL
taskkill /f /im adb.exe >NUL 2>NUL
start /wait /B "" "%~dp08.57.0.1\yyrun.exe" -unreg
rd /s /q "%CommonProgramFiles%\duowan"2>NUL
rd /s /q "%CommonProgramFiles(x86)%\duowan"2>NUL
del /f/s/q "%AppData%\duowan\*" >NUL 2>NUL
rd/s/q "%AppData%\duowan"2>NUL
ping 127.0.0.1 /n 2 >NUL 2>NUL
rd/s/q "%AppData%\duowan"2>NUL
reg delete  HKCU\Software\duowan /f>NUL 2>NUL
del /q "%userprofile%\桌面\歪歪语音.lnk" >NUL  2>NUL 
del /q "%userprofile%\Desktop\歪歪语音.lnk" >NUL  2>NUL
ping 127.0.0.1 /n 3 >NUL 2>NUL
rd/s/q "%AppData%\duowan"2>NUL
SET E=完成!&GOTO MSGBOX

:DesktopLnk
mshta VBScript:Execute("Set a=CreateObject(""WScript.Shell""):Set b=a.CreateShortcut(a.SpecialFolders(""Desktop"") & ""\歪歪语音.lnk""):b.TargetPath=""%~dp0YY.exe"":b.WorkingDirectory=""%~dp0"":b.Save:close")
SET E=完成!&GOTO MSGBOX

:MsgBox
if "%1"=="" mshta VBScript:MsgBox("%e%",vbSystemModal,"")(close)&Cls&Goto Menu