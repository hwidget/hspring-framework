<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
    <entry key="currDetectorResultMap">
        <![CDATA[
            function(){
                if(this._id.name != null){
                    emit({name:this._id.name},1)
                }
            }
        ]]>
    </entry>

    <entry key="totalCountMap">
        <![CDATA[
            function(){
                var names = this.names;
                var count = this.count;
                if(names != null && count != null && count > 1){
                    names.forEach(function(name) {
                        emit(name, 1);
                    })
                }
            }
        ]]>
    </entry>
</properties>