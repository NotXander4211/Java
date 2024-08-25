import os

pathsToClean = ["D:/Programs/Java"]

for path in pathsToClean:
    print(f"Scanning directory {path}")
    _temp = os.listdir(path)
    for file in _temp:
        if os.path.isdir(os.path.join(path,file)):
            print(f"isdir {os.path.join(path,file)}")
            for item in os.listdir(os.path.join(path,file)):
                print(f"Scan {item}")
                if item.endswith(".class"):
                    print(f"Delete {item}")
                    os.remove(os.path.join(path,file,item))
        elif file.endswith(".class"):
            print(f"Delete {file}")
            os.remove(os.path.join(path,file))

print(F"DONE SCANNING ALL DIRECTORIES AND ALL SUBDIRECTORIES")